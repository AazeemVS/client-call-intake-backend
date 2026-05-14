package com.aazeem.clientcallintake.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import com.aazeem.clientcallintake.dto.CallRecordDto;
import com.aazeem.clientcallintake.dto.CreateCallRecordRequest;
import com.aazeem.clientcallintake.model.CallRecord;
import com.aazeem.clientcallintake.service.CallRecordService;

@RestController
@RequestMapping("/api/calls")
public class CallRecordController {

    private final CallRecordService callRecordService;

    public CallRecordController(CallRecordService callRecordService) {
        this.callRecordService = callRecordService;
    }

    @PostMapping
    public ResponseEntity<CallRecordDto> createCallRecord(@RequestBody CreateCallRecordRequest request) {
        CallRecord created = callRecordService.createCallRecord(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(toDto(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CallRecordDto> updateCallRecord(@PathVariable Integer id,
            @RequestBody CreateCallRecordRequest request) {
        if (request.getId() != null && !request.getId().equals(id)) {
            throw new IllegalArgumentException("Path id and request id do not match");
        }
        request.setId(id);
        CallRecord updated = callRecordService.updateCallRecord(id, request);
        return ResponseEntity.ok(toDto(updated));
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<CallRecordDto>> getCallsByClient(@PathVariable Integer clientId) {
        List<CallRecordDto> records = callRecordService.getAllCallsPerClient(clientId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(records);
    }

    private CallRecordDto toDto(CallRecord callRecord) {
        CallRecordDto dto = new CallRecordDto();
        dto.setId(callRecord.getId());
        dto.setCallReason(callRecord.getCallReason());
        dto.setNotes(callRecord.getNotes());
        dto.setPriority(callRecord.getPriority() != null ? callRecord.getPriority().name() : null);
        dto.setStatus(callRecord.getStatus());
        dto.setCreatedAt(callRecord.getCreatedAt());
        dto.setClientId(callRecord.getClient() != null ? callRecord.getClient().getId() : null);
        return dto;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
