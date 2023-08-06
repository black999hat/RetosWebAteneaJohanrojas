package com.example.reto3johanrojas.Repository.CRUD;

import com.example.reto3johanrojas.Model.Gama;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamaCrudRepository extends CrudRepository<Gama,Integer> {

}
