package com.reto_2.web;

import com.reto_2.model.User;
import com.reto_2.service.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Alexander Sánchez Osorio
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/user/")

public class UserWeb {

    /**
     * atributo autowired para usuario
     */
    @Autowired
    private UserApi userApi;

    /**
     * Método para obtener a todos los usuarios de la base de datos
     * @return getAll retorna a todos los usuarios
     */
    @GetMapping("all")
    public List<User> getUsers() {
        return userApi.getAll();
    }

    /**
     * Método para guardar un usuario en base de datos
     * @param user
     * @return user Retorna al usuario actualizado
     */
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return userApi.save(user);
    }

    /**
     * Obtiene al usuario por su correo.
     * @param email
     * @return Boolean Retorna un valor booleano, si existe o no el correo.
     */
    @GetMapping("emailexist/{email}")
    public boolean getEmail(@PathVariable("email") String email){
        return userApi.getByEmail(email);
    }

    /**
     * Obtiene una respuesta con su email y pass, de si existe en la base de datos
     * @param email
     * @param pass
     * @return
     */
    @GetMapping("{email}/{pass}")
    public User userEmailPass(@PathVariable("email") String email, @PathVariable("pass") String pass){
        return userApi.getByEmailPass(email, pass);
    }

    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public User userUpdate(@RequestBody User user){
        return userApi.userUpdate(user);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id")int userId){
        userApi.delete(userId);
    }
}
