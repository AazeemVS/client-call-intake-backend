package com.aazeem.clientcallintake.service;

import org.springframework.stereotype.Service;
import com.aazeem.clientcallintake.dto.CreateCallRecordRequest;
import com.aazeem.clientcallintake.model.CallRecord;
import com.aazeem.clientcallintake.model.Client;
import com.aazeem.clientcallintake.repository.CallRecordRepository;
import com.aazeem.clientcallintake.repository.ClientRepository;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CallRecordService {
    private final CallRecordRepository callRecordRepository;
    private final ClientRepository clientRepository;

    public CallRecordService(CallRecordRepository callRecordRepository, ClientRepository clientRepository) {
        this.callRecordRepository = callRecordRepository;
        this.clientRepository = clientRepository;
    }

    // get all calls for a specific client
    public List<CallRecord> getAllCallsPerClient(Integer clientId) {
        return callRecordRepository.findByClientId(clientId);
    }

    public CallRecord createCallRecord(CreateCallRecordRequest request) {
        Client client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new IllegalArgumentException("Client not found: " + request.getClientId()));

        CallRecord callRecord = new CallRecord();
        if (request.getId() != null) {
            callRecord.setId(request.getId());
        }
        callRecord.setCallReason(request.getCallReason());
        callRecord.setNotes(request.getNotes());
        callRecord.setPriority(request.getPriority());
        callRecord.setStatus(request.getStatus());
        callRecord.setCreatedAt(request.getCreatedAt() != null ? request.getCreatedAt() : LocalDateTime.now());
        callRecord.setClient(client);

        return callRecordRepository.save(callRecord);
    }
}
