package com.reto_2.web;

import com.reto_2.model.Clone;
import com.reto_2.model.Order;
import com.reto_2.service.OrderApi;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexander Sánchez Osorio
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/order/")
public class OrderWeb {

    private OrderApi orderApi;

    /**
     * Metodo COnstructor para Ordenes
     * @param orderApi
     */
    public OrderWeb(OrderApi orderApi) {
        this.orderApi = orderApi;
    }

    /**
     * Método para obtener todas las ordenes de la bd
     * @return
     */
    @GetMapping("all")
    public List<Order> getOrders() {
        return orderApi.getAll();
    }

    /**
     * Obtiene una orden por id
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Optional<Order> getOrderById(@PathVariable("id") int id){
        return orderApi.getOrderById(id);
    }

    /**
     * Método para guardar una orden en bd
     * @param order
     * @return
     */
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return orderApi.save(order);
    }

    /**
     * Trae la zona de una orden
     * @param zona
     * @return
     */
    @GetMapping("/zona/{zona}")
    public List<Order> getOrderByzone(@PathVariable("zona") String zona){
        return orderApi.getOrderByZone(zona);
    }

    /**
     *
     * @param status
     * @return
     */
    @GetMapping("/state/{estado}")
    public List<Order> getOrderBystatus(@PathVariable("estado") String status){
        return orderApi.getOrderByStatus(status);
    }

    /**
     * Actualiza a un usuario en la base de datos
     * @param order
     * @return
     */
    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order orderUpdate(@RequestBody Order order){
        return orderApi.orderUpdate(order);
    }

    /**
     * Eliminar una orden por id
     * @param orderId
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id")int orderId){
        orderApi.deleteById(orderId);
    }

    /**
     * Obtiene usuarios por identificacion
     * @param identification
     * @return
     */
    @GetMapping("/identificacion/{identification}")
    public List<Order> getOrderByIdentification(@PathVariable("identification") String identification) {
        return orderApi.findByIdentification(identification);
    }

    /**
     * Metodo para agregar un producto
     * @param idOrder
     * @param clone
     * @return
     */
    @PutMapping("/add/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Order addProduct(@PathVariable("id") Integer idOrder, @RequestBody Optional<Clone> clone) {
        return orderApi.addProduct(clone, idOrder);
    }

    /**
     * Metodo para agregar cantidad
     *
     * @param idOrder
     * @param cantidad
     * @return
     */
    @PutMapping("/cantidad/{id}/{cantidad}/{idQuantity}")
    @ResponseStatus(HttpStatus.CREATED)
    public Order addCantidad(@PathVariable("id") Integer idOrder, @PathVariable("cantidad") Integer cantidad, @PathVariable("idQuantity") String idQuantity) {
        return orderApi.addCantidad(cantidad, idOrder, idQuantity);
    }

    /**
     * Metodo para buscar el id y el estado de un Asesor
     *
     * @param status
     * @param id
     * @return
     */
    @GetMapping("/state/{status}/{id}")
    public List<Order> getByStatusId(@PathVariable("status") String status, @PathVariable("id") Integer id) {
        return orderApi.orderBySalesManStatusAndId(status, id);
    }

    /**
     * Mmetodo para buscar id y fecha del Asesor
     *
     * @param date
     * @param id
     * @return
     */
    @GetMapping("/date/{date}/{id}")
    public List<Order> getByDateId(@PathVariable("date") String date, @PathVariable("id") Integer id) {
        return orderApi.getByRegisterDayAndSalesManId(date, id);
    }

}
