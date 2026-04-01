package com.aazeem.clientcallintake.repository;

// Imports the client file from the model folder
import com.aazeem.clientcallintake.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    
}
