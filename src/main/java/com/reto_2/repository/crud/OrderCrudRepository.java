package com.reto_2.repository.crud;

import com.reto_2.model.Order;
import com.reto_2.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderCrudRepository extends MongoRepository<Order, Integer> {

    /**
     * Metodo para listar ordenes por identificacoin de usuarios
     * @param identification
     * @return
     */
    @Query("{'salesMan.identification': ?0}")
    List<Order> findByIdentification(final String identification);

    /**
     * Metodo para listar ordenes por zona
     * @param zona
     * @return
     */
    @Query("{'salesMan.zone':?0}")
    List<Order> findByZone(String zona);

    /**
     * Metodo para listar ordenes por estado
     * @param status
     * @return
     */
    @Query("{'salesMan.status':?0}")
    List<Order> findByStatus(String status);

    /**
     * Método para obtener la lista de órdenes por Id de asesor
     *
     * @param id
     * @return
     */
    List<Order> findBySalesManId(Integer id);


    /**
     * Método para obtener las órdenes con un estado específico de un asesor por ID
     *
     * @param id
     * @param status
     * @return
     */
    List<Order> findBySalesManIdAndStatus(Integer id, String status);

    /**
     * Método para Obtener las órdenes por fecha de un Asesor por ID
     *
     * @param registerDay
     * @param id
     * @return
     */
    List<Order> findByRegisterDayContainsAndSalesManId(String registerDay, Integer id);




}
