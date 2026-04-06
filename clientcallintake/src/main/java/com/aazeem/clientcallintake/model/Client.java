package com.aazeem.clientcallintake.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String email;
}
