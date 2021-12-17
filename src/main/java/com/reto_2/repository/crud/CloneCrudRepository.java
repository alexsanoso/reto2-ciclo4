package com.reto_2.repository.crud;

import com.reto_2.model.Clone;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Alexander Sánchez Osorio
 */
public interface CloneCrudRepository extends MongoRepository<Clone, Integer> {

    /**
     * Listar Clones que tengan un precio menor o igual al ingresado
     *
     * @param price
     * @return
     */
    List<Clone> findCloneByPriceIsLessThanEqual(Double price);

    /**
     * Listar Clones por un String enviado, si se encuentra en su descripción
     *
     * @param description
     * @return
     */
    List<Clone> findCloneByDescriptionRegex(String description);

}
