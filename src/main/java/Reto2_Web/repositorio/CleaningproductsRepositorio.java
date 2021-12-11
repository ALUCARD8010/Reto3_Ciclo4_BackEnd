/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.repositorio;

import Reto2_Web.interfaces.InterfaceCleaningproducts;
import Reto2_Web.modelo.Cleaningproducts;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class CleaningproductsRepositorio {
    @Autowired
    private InterfaceCleaningproducts repository;
    
    public List<Cleaningproducts> getAll() {
        return repository.findAll();
    }
    
    public Optional<Cleaningproducts> getCleaningproducts(Integer id){
        return repository.findById(id);
    }

    public Cleaningproducts create(Cleaningproducts product) {
        return repository.save(product);
    }

    public void update(Cleaningproducts product) {
        repository.save(product);
    }
    
    public void delete(Cleaningproducts product) {
        repository.delete(product);
    }
}
