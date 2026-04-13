package com.aazeem.clientcallintake.repository;

// Import the Callrecord file form the model file
import com.aazeem.clientcallintake.model.CallRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CallRecordRepository extends JpaRepository<CallRecord, Integer> {
    List<CallRecord> findByClientId(Integer clientId);
}
