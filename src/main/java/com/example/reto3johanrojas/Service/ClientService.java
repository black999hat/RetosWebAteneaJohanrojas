package com.example.reto3johanrojas.Service;

import com.example.reto3johanrojas.Model.Client;
import com.example.reto3johanrojas.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return (Client) clientRepository.save((Client) client);
        } else {
            Optional<Client> clientEncontrado = getClient(client.getIdClient());
            if (clientEncontrado.isEmpty()) {
                return (Client) clientRepository.save((Client) client);
            } else {
                return client;
            }
        }
    }

    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> clientEncontrado = getClient(client.getIdClient());
            if (clientEncontrado.isPresent()) {
                if (client.getEmail() != null) {
                    clientEncontrado.get().setEmail(client.getEmail());
                }
                if (client.getName() != null) {
                    clientEncontrado.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    clientEncontrado.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    clientEncontrado.get().setPassword(client.getPassword());
                }

                return (Client) clientRepository.save(clientEncontrado.get());
            }else {
                return client;
            }
        }else {
            return client;
        }
    }
    public  boolean delete(int id){
        Boolean respuesta = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
