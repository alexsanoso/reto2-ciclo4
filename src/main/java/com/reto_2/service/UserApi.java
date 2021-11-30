package com.reto_2.service;

import com.reto_2.model.User;
import com.reto_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * @author Alexander Sánchez Osorio
 */
@Service
public class UserApi {

    /**
     * Atributo autowired para usuario
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Metodo para obtener todos los usuarios
     * @return userRepository
     */
    public List<User> getAll(){
        return userRepository.getAll();
    }

    /**
     * Guardar un usuario en la base de datos
     * @param user
     * @return user Devuelve el usuario actualizado.
     */
    public User save(User user){

        List<User> users = userRepository.getAll();

        if (users.size() == 0){
            return userRepository.save(user);
        }else if (getByEmail(user.getEmail()) == false) {
            return userRepository.save(user);
        }
        return user;
    }

    /**
     * Validar si un usuario existe en la base de datos
     * @param email
     * @return flag Devuelve el valor booleano actualizado
     */
    public boolean getByEmail(String email){

        List<User> users = userRepository.getAll();
        boolean flag = false;

        for (User user: users) {
            if(email.equals(user.getEmail())){
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Autentificar si un usuario existe en la base de datos
     * @param email
     * @param pass
     * @return noExiste Devuelve el valor indefinido cuando el usuario no existe en la base de datos
     */
    public User getByEmailPass(String email, String pass){
        List<User> users = userRepository.getAll();
        User noExiste = new User();

        for (User user: users) {
            if(email.equals(user.getEmail()) && pass.equals(user.getPassword())){
                return user;
            }
        }
        return noExiste;
    }

    /**
     * Borrar un usuario por id en la base de datos
     * @param idUser
     */
    public void delete (Integer idUser){
        Optional<User> user = userRepository.getUserById(idUser);
        if(user.isPresent()){
            userRepository.deleteById(idUser);
        }
    }

    /**
     * Actualizar un usuario de la base de datos
     * @param user
     * @return
     */
    public User userUpdate(User user){
        Optional<User> exist = userRepository.getUserById(user.getId());
        if(exist.isPresent()) {
            if (user.getIdentification() != null) {
                exist.get().setIdentification(user.getIdentification());
            }
            if(user.getName() != null){
                exist.get().setName(user.getName());
            }
            if(user.getAddress() != null){
                exist.get().setAddress(user.getAddress());
            }
            if(user.getCellPhone() != null){
                exist.get().setCellPhone(user.getCellPhone());
            }
            if(user.getEmail() != null){
                exist.get().setEmail(user.getEmail());
            }
            if(user.getPassword() != null){
                exist.get().setPassword(user.getPassword());
            }
            if(user.getZone() != null){
                exist.get().setZone(user.getZone());
            }
            if(user.getType() != null){
                exist.get().setType(user.getType());
            }
            return userRepository.save(exist.get());
        }
        return user;
    }
}