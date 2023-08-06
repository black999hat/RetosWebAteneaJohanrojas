package com.example.reto3johanrojas.Repository;

import com.example.reto3johanrojas.Model.Client;
import com.example.reto3johanrojas.Repository.CRUD.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<com.example.reto3johanrojas.Model.Client> findAll(){
        return (List<com.example.reto3johanrojas.Model.Client>) clientCrudRepository.findAll();
    }
    public Optional<com.example.reto3johanrojas.Model.Client> getClient(int id){
        return clientCrudRepository.findById(id);

    }
    public Client save(Client client){
        return clientCrudRepository.save(client);
    }
    public void  delete(Client client){
        clientCrudRepository.delete(client);
    }
}