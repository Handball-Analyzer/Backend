package com.Handball.Analyzer.controller.webfront;

import com.Handball.Analyzer.model.Gym;
import com.Handball.Analyzer.repository.GymRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webfront/v1/gym")
public class GymController {
    @Autowired
    GymRepository gymRepository;

    @GetMapping
    public ResponseEntity<?> getGym(){
        List<Gym> gymList = gymRepository.findAll();
        return ResponseEntity.ok(gymList);
    }

    @PostMapping
    public ResponseEntity<?> createGym(@RequestBody Gym gymDto){
        Gym created = gymRepository.save(gymDto);
        return ResponseEntity.ok(created);
    }
}
