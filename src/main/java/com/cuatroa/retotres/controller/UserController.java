package com.cuatroa.retotres.controller;

import com.cuatroa.retotres.model.User;
import com.cuatroa.retotres.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
 * @author jotajotamcastillo
 */

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

/**
 * Clase controladora de rutas
 */

public class UserController {

    @Autowired
    /**
	* instacia de servicio a usar
	*/
    private UserService userService;
    

    @GetMapping("/all")
    /**
	* método para listar todos los usuarios
	*/
    public List<User> getAll() {
        return userService.getAll();
    }
    
    @GetMapping("/{id}")
    /**
	* método para ubicar usuarios por id
	*/
    public Optional <User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @PostMapping("/new")
    /**
	* método para agregar usuarios
	*/
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    
    @PutMapping("/update")
    /**
	* método para actualizar un usuario
	*/
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    /**
	* método para eliminar usuario
	*/
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }
    
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }
    
    @GetMapping("/emailexist/{email}")
    /**
	* método para validar email de usuario
	*/
    public boolean emailexists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
}
