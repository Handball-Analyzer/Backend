package com.Handball.Analyzer.controller.webfront;

import com.Handball.Analyzer.model.UseRequest;
import com.Handball.Analyzer.repository.UseRequestRepository;
import com.Handball.Analyzer.requestDtos.webfront.UseRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("webfront/v1/userequest")
public class UseReqestController {

    @Autowired
    UseRequestRepository useRequestRepository;

    @PostMapping("/send")
    public ResponseEntity<?> createUseRequest(@RequestBody UseRequestDto useRequestDto){
        if (useRequestDto.getEmail().isEmpty() || useRequestDto.getEmail().isBlank() || useRequestDto.getLastname().isEmpty()||useRequestDto.getFirstname().isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        UseRequest useRequest = new UseRequest(useRequestDto.getFirstname(), useRequestDto.getLastname(), useRequestDto.getEmail(), useRequestDto.getClubName(), useRequestDto.getMessage(), false,false);
        return ResponseEntity.status(201).body(useRequest);
    }

}
