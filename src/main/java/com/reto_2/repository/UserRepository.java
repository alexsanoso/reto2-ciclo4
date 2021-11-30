package com.reto_2.repository;

import com.reto_2.model.User;
import com.reto_2.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexander Sánchez Osorio
 */
@Repository
public class UserRepository {

    /**
     * atributo para user
     */
    @Autowired
    private UserCrudRepository userCrudRepository;

    /**
     * Metodo para obtener cada usuario por Id
     * @param id
     * @return
     */
    public Optional<User> getUserById(int id){
        return userCrudRepository.findById(id);
    }

    /**
     * Método para obtener a todos los usuarios
     * @return
     */
    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }

    /**
     * Método para guardar un usuario
     * @param user
     * @return userCrudRepository.save(user)
     */
    public User save(User user){
        return userCrudRepository.save(user);
    }

    /**
     * Metodo para borrar un usuario por Id
     * @param id
     */
    public void deleteById (Integer id){
        userCrudRepository.deleteById(id);
    }

}
