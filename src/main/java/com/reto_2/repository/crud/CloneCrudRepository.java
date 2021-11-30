package com.reto_2.repository.crud;

import com.reto_2.model.Clone;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Alexander Sánchez Osorio
 */
public interface CloneCrudRepository extends MongoRepository<Clone, Integer> {
}
