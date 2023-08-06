package com.example.reto3johanrojas.Repository.CRUD;

import com.example.reto3johanrojas.Model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
