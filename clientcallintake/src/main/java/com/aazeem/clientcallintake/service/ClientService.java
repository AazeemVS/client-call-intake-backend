package com.aazeem.clientcallintake.service;

import org.springframework.stereotype.Service;
import com.aazeem.clientcallintake.repository.ClientRepository;
import com.aazeem.clientcallintake.model.Client;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Methods use the client reposityory to get data from db
    // and use JPA functions to get the data and return it
    // Replicate the same process for CallRecordService
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClient(Integer id) {
        return clientRepository.findById(id);
    }

}