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

    public CloneWeb(CloneApi cloneApi) {
        this.cloneApi = cloneApi;
    }

    @GetMapping("all")
    public List<Clone> getClones(){
        return cloneApi.getAll();
    }

    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone save(@RequestBody Clone clone){
        return cloneApi.save(clone);
    }

    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone cloneUpdate(@RequestBody Clone clone){
        return cloneApi.save(clone);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id")int cloneId){
        cloneApi.delete(cloneId);
    }
}
