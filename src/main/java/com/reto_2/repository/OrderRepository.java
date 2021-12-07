package com.reto_2.repository;

import com.reto_2.model.Order;
import com.reto_2.repository.crud.OrderCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexander Sánchez Osorio
 */
@Repository
public class OrderRepository {

    public OrderCrudRepository orderCrudRepository;

    /**
     * Metodo constructor para Order
     * @param orderCrudRepository
     */
    public OrderRepository(OrderCrudRepository orderCrudRepository) {
        this.orderCrudRepository = orderCrudRepository;
    }

    /**
     * Metodo para obtener una orden por id
     * @param id
     * @return
     */
    public Optional<Order> getOrderById(int id){
        return orderCrudRepository.findById(id);
    }

    /**
     * Metodo para traer todas las ordenes
     * @return
     */
    public List<Order> getAll(){
        return orderCrudRepository.findAll();
    }

    /**
     * Metodo para obtener la zona de cada orden
     * @param zona
     * @return
     */
    public List<Order> getOrderByZone(String zona){
        return orderCrudRepository.findByZone(zona);
    }

    /**
     * Metodo para obtener el estado de la orden
     * @param status
     * @return
     */
    public List<Order> getOrderByStatus(String status){
        return orderCrudRepository.findByStatus(status);
    }


    /**
     * Metodo para guardar una orden
     * @param order
     * @return
     */
    public Order save(Order order){
        return orderCrudRepository.save(order);
    }

    /**
     * Metodo para eliminar una orden por id
     * @param id
     */
    public void deleteById (Integer id){
        orderCrudRepository.deleteById(id);
    }
}

