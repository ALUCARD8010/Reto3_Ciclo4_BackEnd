/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.controlador;

import Reto2_Web.modelo.Cleaningproducts;
import Reto2_Web.servicio.CleaningproductsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/cleaningprod")
@CrossOrigin("*")
public class CleaningproductsController {
    
    @Autowired
    private CleaningproductsService cleaningproductsService;
       
    @GetMapping("/all")
    public List<Cleaningproducts> getAll() {
        return cleaningproductsService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Cleaningproducts> getCleaningproducts(@PathVariable("id") Integer id) {
        return cleaningproductsService.getCleaningProducts(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cleaningproducts create(@RequestBody Cleaningproducts product) {
        return cleaningproductsService.create(product);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cleaningproducts update(@RequestBody Cleaningproducts product) {
        return cleaningproductsService.update(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return cleaningproductsService.delete(id);
    }
    
}
