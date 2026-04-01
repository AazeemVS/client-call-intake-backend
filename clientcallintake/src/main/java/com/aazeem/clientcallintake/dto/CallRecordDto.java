package com.aazeem.clientcallintake.dto;

import java.time.LocalDateTime;

import com.aazeem.clientcallintake.model.Client;
import com.aazeem.clientcallintake.model.CallStatus;
public class CallRecordDto {
    private Integer id;
    private String callReason;
    private String notes;
    private String priority;
    private CallStatus status;
    private LocalDateTime createdAt;
    private Integer clientId;

        // default constructor
    public CallRecordDto() {

    }

    // parameterized constructor
    public CallRecordDto(Integer id, String callReason, String notes, String priority, CallStatus status, LocalDateTime createdAt, Integer clientId) {
        this.id = id;
        this.callReason = callReason;
        this.notes = notes;
        this.priority = priority;
        this.status = status;
        this.createdAt = createdAt;
        this.clientId = clientId;
    }

    //create getters and setters for each variable
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCallReason() {
        return callReason;
    }

    public void setCallReason(String callReason) {
        this.callReason = callReason;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPriority(){
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public CallStatus getStatus() {
        return status;
    }    

    public void setStatus(CallStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}
