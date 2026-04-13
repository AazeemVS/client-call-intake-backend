package com.aazeem.clientcallintake.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aazeem.clientcallintake.dto.ClientDto;
import com.aazeem.clientcallintake.model.Client;
import com.aazeem.clientcallintake.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * GET /api/clients
     *
     * Returns a list of all clients in DTO form.
     * The controller uses the service to load all client entities,
     * then converts each entity into a simple response object.
     */
    @GetMapping
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    /**
     * GET /api/clients/{id}
     *
     * Returns a single client by ID.
     * If the client is found, returns 200 OK with the client DTO.
     * If not, returns 404 Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Integer id) {
        return clientService.getClient(id)
                .map(client -> ResponseEntity.ok(toDto(client)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Maps a Client entity to a ClientDto for API responses.
     */
    private ClientDto toDto(Client client) {
        ClientDto dto = new ClientDto();
        dto.setId(client.getId());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setPhoneNum(client.getPhoneNum());
        dto.setEmail(client.getEmail());
        return dto;
    }
}
