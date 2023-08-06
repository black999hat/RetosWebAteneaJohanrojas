package com.example.reto3johanrojas.Repository;

import com.example.reto3johanrojas.Model.Gama;
import com.example.reto3johanrojas.Repository.CRUD.GamaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GamaRepository {
    private static GamaCrudRepository gamaCrudRepository = null;
    @Autowired
    public GamaRepository(GamaCrudRepository gamaCrudRepository) {
        this.gamaCrudRepository = gamaCrudRepository;
    }

    public static List<Gama> findAll(){
        return(List<Gama>) gamaCrudRepository.findAll();
    }
    public Optional<Gama> getGama(int id){
        return gamaCrudRepository.findById(id);
    }
    public Gama save (Gama gama){
        return gamaCrudRepository.save(gama);
    }
    public void  delete(Gama gama){
        gamaCrudRepository.delete(gama);
    }
}





