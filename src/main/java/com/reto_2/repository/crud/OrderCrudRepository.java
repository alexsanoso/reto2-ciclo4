package com.reto_2.repository.crud;

import com.reto_2.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderCrudRepository extends MongoRepository<Order, Integer> {

    @Query("{'salesMan.zone':?0}")
    public List<Order> findByZone(String zona);

    @Query("{'salesMan.status':?0}")
    public List<Order> findByStatus(String status);
}
