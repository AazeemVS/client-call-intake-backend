package com.aazeem.clientcallintake.repository;

import com.aazeem.clientcallintake.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Client entities.
 *
 * Extending JpaRepository provides standard CRUD operations and
 * query methods such as findAll(), findById(), save(), and deleteById().
 * This repository is used by the service layer to load and persist clients.
 */
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
