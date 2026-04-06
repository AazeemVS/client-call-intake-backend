package com.aazeem.clientcallintake.service;

import org.springframework.stereotype.Service;
import com.aazeem.clientcallintake.repository.ClientRepository;
import com.aazeem.clientcallintake.model.Client;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return List.of(); // placeholder return statement
    }

}