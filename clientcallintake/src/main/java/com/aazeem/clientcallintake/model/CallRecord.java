package com.aazeem.clientcallintake.model;
import java.time.LocalDateTime;

public class CallRecord {
    private int id;
    private String callReason;
    private String notes;
    private String priority;
    private String status;
    private LocalDateTime createdAt;
    private Client client;
}
