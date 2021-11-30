package com.reto_2.repository;

import com.reto_2.model.Clone;
import com.reto_2.repository.crud.CloneCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CloneRepository {

    private CloneCrudRepository cloneCrudRepository;

    /**
     * Metodo constructor
     * @param cloneCrudRepository
     */
    public CloneRepository(CloneCrudRepository cloneCrudRepository) {
        this.cloneCrudRepository = cloneCrudRepository;
    }

    /**
     * metodo para obtener cada producto por Id
     * @param id
     * @return
     */
    public Optional<Clone> getCloneById(int id){
        return cloneCrudRepository.findById(id);
    }

    /**
     * Metodo para obtener a todos los productos
     * @return
     */
    public List<Clone> getAll(){
        return (List<Clone>) cloneCrudRepository.findAll();
    }

    /**
     * Metodo para guardar cada producto
     * @param clone
     * @return
     */
    public Clone save(Clone clone){
        return cloneCrudRepository.save(clone);
    }

    /**
     * Metodo para borrar un producto por Id
     * @param id
     */
    public void deleteById (Integer id){
        cloneCrudRepository.deleteById(id);
    }

}
