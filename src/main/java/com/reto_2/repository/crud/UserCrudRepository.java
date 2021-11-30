package com.reto_2.repository.crud;

import com.reto_2.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Alexander Sánchez Osorio
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {
}
