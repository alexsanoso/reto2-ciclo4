package com.reto_2.web;

import com.reto_2.model.Clone;
import com.reto_2.service.CloneApi;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alexander Sánchez Osorio
*/
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/clone/")
public class CloneWeb {


    public CloneApi cloneApi;

    /**
     * Metodo constructor para clone
     * @param cloneApi
     */
    public CloneWeb(CloneApi cloneApi) {
        this.cloneApi = cloneApi;
    }

    /**
     * Metodo para asignar una id a un producto creado
     * @return
     */
    @GetMapping("/newid")
    public int getId() {
        return cloneApi.getId();
    }

    /**
     * Metodo para obtener para obtener todos los productos
     * @return
     */
    @GetMapping("all")
    public List<Clone> getClones(){
        return cloneApi.getAll();
    }

    /**
     * Metodo para guardar todos los productos
     * @param clone
     * @return
     */
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone save(@RequestBody Clone clone){
        return cloneApi.save(clone);
    }

    /**
     * Metodo para actualizar un producto
     * @param clone
     * @return
     */
    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone cloneUpdate(@RequestBody Clone clone){
        return cloneApi.save(clone);
    }

    /**
     * metodo para eliminar un producto
     * @param cloneId
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id")int cloneId){
        cloneApi.delete(cloneId);
    }
}
