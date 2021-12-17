package com.reto_2.service;

import com.reto_2.model.Clone;
import com.reto_2.model.Order;
import com.reto_2.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Alexander Sánchez Osorio
 */
@Service
public class OrderApi {

    private OrderRepository orderRepository;

    public OrderApi(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Metodo para traer todas las ordenes
     * @return
     */
    public List<Order> getAll(){
        return orderRepository.getAll();
    }

    /**
     * Metodo para traer una orden por Id
     * @param id
     * @return
     */
    public Optional getOrderById(int id){
        return orderRepository.getOrderById(id);
    }

        /**
     * Metodo para obtener las zonas
     * @param zona
     * @return
     */
    public List<Order> getOrderByZone(String zona){
        return orderRepository.getOrderByZone(zona);
    }

    /**
     * Metodo para obtener el estado de una orden
     * @param status
     * @return
     */
    public List<Order> getOrderByStatus(String status){
        return orderRepository.getOrderByStatus(status);
    }

    /**
     * Metodo para guardar una orden
     * @param order
     * @return
     */
    public Order save(Order order){

        List<Order> orders = orderRepository.getAll();
        Integer idAuto = orders.size();
        idAuto++;
        Optional<Order> exist = orderRepository.getOrderById(idAuto);
        if (exist.isPresent()){
            return order;
        }
        if (order.getId() == null){
            order.setId(idAuto);
        }

        if(order.getId() == null){
            return orderRepository.save(order);
        }else{
            Optional<Order> existOrder = orderRepository.getOrderById(order.getId());
            if(existOrder.isPresent()){
                return order;
            }else {
                return orderRepository.save(order);
            }
        }
    }

    /**
     * Metodo para actualizar el estado de una orden
     * @param order
     * @return
     */
    public Order orderUpdate(Order order){
        Optional<Order> exist = orderRepository.getOrderById(order.getId());
        if(exist.isPresent()) {
            if (order.getRegisterDay() != null) {
                exist.get().setRegisterDay(order.getRegisterDay());
            }
            if (order.getStatus() != null) {
                exist.get().setStatus(order.getStatus());
            }
            if (order.getSalesMan() != null) {
                exist.get().setSalesMan(order.getSalesMan());
            }
            if (order.getProducts() != null) {
                exist.get().setProducts(order.getProducts());
            }
            if (order.getQuantities() != null) {
                exist.get().setQuantities(order.getQuantities());
            }
            return orderRepository.save(exist.get());
        }
        return order;
    }

    /**
     * Metodo para borrar una orden por id
     * @param idOrder
     */
    public void deleteById (Integer idOrder){
        Optional<Order> order = orderRepository.getOrderById(idOrder);
        if(order.isPresent()){
            orderRepository.deleteById(idOrder);
        }
    }

    /**
     * Metodo para listar por identificacion de usuario
     * @param identification
     * @return
     */
    public List<Order> findByIdentification(String identification) {
        return orderRepository.findByIdentification(identification);
    }

    /**
     * Metodo para agregar un producto
     *
     * @param clone
     * @param idOrder
     * @return
     */
    public Order addProduct(Optional<Clone> clone, Integer idOrder) {
        if (clone.isPresent()) {
            Optional<Order> exist = orderRepository.getOrderById(idOrder);
            Map<Integer, Clone> products = exist.get().getProducts();
            Integer var = 0;
            Set<Integer> keys = products.keySet();

            ArrayList<Integer> claves = new ArrayList<>();
            for (Integer key : keys) {
                claves.add(key);
            }
            Collections.sort(claves);
            int mayorKey = 0;
            for (Integer clave : claves) {

                if (clave > mayorKey) {
                    mayorKey = clave;
                }
            }
            var = mayorKey + 1;

            products.put(var, clone.get());
            exist.get().setProducts(products);
            return orderRepository.save(exist.get());
        } else {
            return Order.builder().build();
        }
    }

    /**
     * Metodo para agregar cantidad
     *
     * @param cantidad
     * @param idOrder
     * @return
     */
    public Order addCantidad(Integer cantidad, Integer idOrder, String idQuantity) {
        if (cantidad > 0) {
            Optional<Order> exist = orderRepository.getOrderById(idOrder);
            Map<String, Integer> cantidades = exist.get().getQuantities();
            Integer var = 0;
            if (cantidades.isEmpty()) {
                var = cantidades.size() + 1;
            } else if (cantidades.containsKey(idQuantity)){
                cantidades.put(idQuantity, cantidad);
                exist.get().setQuantities(cantidades);
                return orderRepository.save(exist.get());
            }else {
                Set<String> keys = cantidades.keySet();
                ArrayList<String> claves = new ArrayList<>();
                for (String key : keys) {
                    claves.add(key);
                }
                Collections.sort(claves);
                int mayorKey = 0;
                int claveInt;
                for (String clave : claves) {
                    claveInt = Integer.parseInt(clave);
                    if (claveInt > mayorKey) {
                        mayorKey = claveInt;
                    }
                }
                var = mayorKey + 1;
            }
            cantidades.put(var + "", cantidad);
            exist.get().setQuantities(cantidades);

            return orderRepository.save(exist.get());
        } else {
            return Order.builder().build();
        }
    }

    /**
     * Metodo para buscar el registro y el id del asesor
     *
     * @param registerDay
     * @param id
     * @return
     */
    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id) {
        return orderRepository.findByRegisterDay(registerDay , id);

    }

    /**
     * Metodo para busca el asesor por estado y id
     *
     * @param idUser
     * @return
     */

    public List<Order> orderBySalesManStatusAndId(String status, Integer idUser) {
        return orderRepository.findByStatus(idUser, status);
    }

}
