package com.reto_2.service;

import com.reto_2.model.Clone;
import com.reto_2.repository.CloneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloneApi {

    private CloneRepository cloneRepository;

    /**
     * Metodo constructor de Clone
     * @param cloneRepository
     */
    public CloneApi(CloneRepository cloneRepository) {
        this.cloneRepository = cloneRepository;
    }

    /**
     * Metodo para traer la lista de productos en la clase Clone
     * @return cloneRepository.getAll()
    */
    public List<Clone> getAll(){
        return cloneRepository.getAll();
    }

    /**
     * Metodo para guardar un producto
     * @param clone
     * @return
    */
    public Clone save(Clone clone){

        List<Clone> clones = cloneRepository.getAll();

        if (clones.size() == 0){
            return cloneRepository.save(clone);
        }else if (clones.isEmpty() == false) {
            return cloneRepository.save(clone);
        }
        return clone;
    }

    /**
     * Metodo para obtener un producto por Id
     * @param id
     * @return
     */
    public boolean getById(String id){

        List<Clone> clones = cloneRepository.getAll();
        boolean flag = false;

        for (Clone clone: clones) {
            if(id.equals(clone.getId())){
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Metodo para eliminar un producto
     * @param id
     */
    public void delete(int id){
        cloneRepository.deleteById(id);
    }
}
