package com.reto_2.repository;

import com.reto_2.model.Clone;
import com.reto_2.repository.crud.CloneCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CloneRepository {

    private CloneCrudRepository cloneCrudRepository;

    public CloneRepository(CloneCrudRepository cloneCrudRepository) {
        this.cloneCrudRepository = cloneCrudRepository;
    }

    public Optional<Clone> getCloneById(int id){
        return cloneCrudRepository.findById(id);
    }

    public List<Clone> getAll(){
        return (List<Clone>) cloneCrudRepository.findAll();
    }

    public Clone save(Clone clone){
        return cloneCrudRepository.save(clone);
    }

    public void deleteById (Integer id){
        cloneCrudRepository.deleteById(id);
    }

}
