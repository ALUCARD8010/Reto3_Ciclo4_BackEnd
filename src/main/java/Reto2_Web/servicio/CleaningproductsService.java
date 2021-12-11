/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.servicio;

import Reto2_Web.modelo.Cleaningproducts;
import Reto2_Web.repositorio.CleaningproductsRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class CleaningproductsService {
    @Autowired
    private CleaningproductsRepositorio cleaningProduct;

    public List<Cleaningproducts> getAll() {
        return cleaningProduct.getAll();
    }

   public Optional<Cleaningproducts> getCleaningProducts(Integer id) {
        return cleaningProduct.getCleaningproducts(id);
    }

    public Cleaningproducts create(Cleaningproducts product) {
        if (product.getId() == null) {
            return product;
        } else {
            return cleaningProduct.create(product);
        }
    }

    public Cleaningproducts update(Cleaningproducts product) {

        if (product.getId() != null) {
            Optional<Cleaningproducts> productDb = cleaningProduct.getCleaningproducts(product.getId());
            if (!productDb.isEmpty()) {
                
                if (product.getBrand()!= null) {
                    productDb.get().setBrand(product.getBrand());
                }
                
                if (product.getCategory() != null) {
                    productDb.get().setCategory(product.getCategory());
                }
                
                if (product.getDescription() != null) {
                    productDb.get().setDescription(product.getDescription());
                }
                if (product.getPrice() != 0.0) {
                    productDb.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    productDb.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                    productDb.get().setPhotography(product.getPhotography());
                }
                productDb.get().setAvailability(product.isAvailability());
                cleaningProduct.update(productDb.get());
                return productDb.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }

    public boolean delete(Integer id) {
        Boolean aBoolean = getCleaningProducts(id).map(accesory -> {
            cleaningProduct.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
