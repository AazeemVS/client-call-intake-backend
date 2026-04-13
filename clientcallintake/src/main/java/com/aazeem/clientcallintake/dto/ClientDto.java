package com.aazeem.clientcallintake.dto;

/**
 * Data Transfer Object for client responses.
 *
 * This DTO is used by controllers to send client data to API callers.
 * It contains only the fields that should be exposed in API responses,
 * avoiding direct exposure of entity internals.
 */
public class ClientDto {
    /** Unique identifier for the client. */
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
     * Default constructor required for object mapping and serialization.
     */
    public ClientDto() {
    }

    /**
     * Full constructor for easier construction in tests or mapping code.
     */
    public ClientDto(int id, String firstName, String lastName, String phoneNum, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
