package com.example.reto3johanrojas.Repository.CRUD;

import com.example.reto3johanrojas.Model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
}
