package com.Handball.Analyzer.controller.backoffice;

import com.Handball.Analyzer.model.UseRequest;
import com.Handball.Analyzer.repository.UseRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("backoffice/v1/userequest")
public class UseRequestController {
    @Autowired
    UseRequestRepository useRequestRepository;

    @GetMapping
    public ResponseEntity<List<UseRequest>> getAllUseRequests(){
        List<UseRequest> useRequestList = useRequestRepository.findAll();
        return ResponseEntity.ok(useRequestList);
    }
    @PutMapping("/{useRequestId}/changeanswered")
    public ResponseEntity<?> changeAnswered(@PathVariable UUID useRequestId) {
        try {
            UseRequest useRequest = useRequestRepository.findById(useRequestId).orElseThrow();
            useRequest.setAnswered(!useRequest.getAnswered());
            useRequestRepository.save(useRequest);
            return ResponseEntity.ok(useRequest);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }
    @PutMapping("/{useRequestId}/changefinished")
    public ResponseEntity<?> changeFinished(@PathVariable UUID useRequestId) {
        try {
            UseRequest useRequest = useRequestRepository.findById(useRequestId).orElseThrow();
            useRequest.setFinished(!useRequest.getFinished());
            useRequestRepository.save(useRequest);
            return ResponseEntity.ok(useRequest);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }
}
