package com.example.reto3johanrojas.Service;

import com.example.reto3johanrojas.Model.Gama;
import com.example.reto3johanrojas.Repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamaService {
    @Autowired
    private GamaRepository gamaRepository;

    public List<Gama> getAll(){
        return GamaRepository.findAll();
    }
    public Optional<Gama> getGama(Integer id) {
        return gamaRepository.getGama(id);
    }
    public Gama save(Gama gama) {
        if (gama.getIdGama() == null) {
            return gamaRepository.save(gama);
        } else {
            Optional<Gama> gamaEncontrado = getGama(gama.getIdGama());
            if (gamaEncontrado.isEmpty()) {
                return gamaRepository.save(gama);
            } else {
                return gama;
            }
        }
    }
    public Gama update(Gama gama) {
        if (gama.getIdGama() != null) {
            Optional<Gama> gamaEncontrado = getGama(gama.getIdGama());
            if (gamaEncontrado.isPresent()) {
                if (gama.getName() != null) {
                    gamaEncontrado.get().setName(gama.getName());
                }
                if (gama.getDescription() != null) {
                    gamaEncontrado.get().setDescription(gama.getDescription());
                }
                return gamaRepository.save(gamaEncontrado.get());
            }else {
                return gama;
            }
        }else {
            return gama;
        }
    }
    public  boolean delete(Integer id){
        Boolean respuesta = getGama(id).map(gama -> {
            gamaRepository.delete(gama);
            return true;
        }).orElse(false);
        return respuesta;
    }

}
