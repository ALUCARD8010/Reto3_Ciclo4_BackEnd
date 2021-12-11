/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.repositorio;

import Reto2_Web.interfaces.InterfaceUser;
import Reto2_Web.modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class UserRepositorio {
    @Autowired
    private InterfaceUser userRepositorio;
     
    public List<User> getAll() {
        return (List<User>) userRepositorio.findAll();
    }

    public Optional<User> getUser(Integer id) {
        return userRepositorio.findById(id);
    }

    public User create(User user) {
        return userRepositorio.save(user);
    }
    
    public void update(User user) {
        userRepositorio.save(user);
    }
    
    public void delete(User user) {
        userRepositorio.delete(user);
    }

    public boolean emailExists(String email) {
        Optional<User> usuario = userRepositorio.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    
    public Optional<User> authenticateUser(String email, String password) {
        return userRepositorio.findByEmailAndPassword(email, password);
    }
     
     
}
