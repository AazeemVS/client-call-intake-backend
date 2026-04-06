package com.aazeem.clientcallintake.dto;

public class ClientDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String email;

    // empty constructor that lets Java create the obj without values.
    public ClientDto() {
    }

    public ClientDto(int id, String firstName, String lastName, String phoneNum, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public Integer getiD() {
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

    public void setPhoneNumber(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
