package com.example.reto3johanrojas.Repository.CRUD;

import com.example.reto3johanrojas.Model.Car;
import com.example.reto3johanrojas.Repository.CarRepository;
import org.springframework.data.repository.CrudRepository;

public interface CarCrudRepository extends CrudRepository<Car, Integer> {

}
