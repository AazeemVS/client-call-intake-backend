package com.aazeem.clientcallintake.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * JPA entity representing a client record.
 *
 * This entity maps to the client table in the database and stores
 * the client identity and contact details used by the application.
 */
@Entity
public class Client {
    /** Primary key for the client. */
    @Id
    private Integer id;

    /** Client first name. */
    private String firstName;

    /** Client last name. */
    private String lastName;

    /** Client phone number. */
    private String phoneNum;

    /** Client email address. */
    private String email;

    /**
     * Returns the client ID.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Returns the client's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the client's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the client's phone number.
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * Returns the client's email address.
     */
    public String getEmail() {
        return email;
    }
}
