package com.aazeem.clientcallintake.service;

import org.springframework.stereotype.Service;
import com.aazeem.clientcallintake.repository.ClientRepository;
import com.aazeem.clientcallintake.model.Client;
import java.util.List;
import java.util.Optional;

/**
 * Service layer for client operations.
 *
 * This class coordinates client data access by calling the repository and
 * returning domain objects to the controller layer. It keeps controller code
 * clean and centralizes client-related business logic.
 */
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Returns all clients from the database.
     *
     * This method delegates to the ClientRepository and returns the full list
     * of Client entities for use in API responses.
     */
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    /**
     * Returns a single client by its ID.
     *
     * If a client with the given ID exists, the Optional contains the client.
     * Otherwise, the Optional is empty and the controller can return 404.
     */
    public Optional<Client> getClient(Integer id) {
        return clientRepository.findById(id);
    }

}