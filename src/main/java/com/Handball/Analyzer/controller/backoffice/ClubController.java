package com.Handball.Analyzer.controller.backoffice;

import com.Handball.Analyzer.model.Club;
import com.Handball.Analyzer.repository.ClubRepository;
import com.Handball.Analyzer.requestDtos.webfront.createDtos.ClubCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/backoffice/v1/clubs")
public class ClubController {

    @Autowired
    ClubRepository clubRepository;

    @GetMapping
    public ResponseEntity<List<Club>> getAllClubs() {
        List<Club> clubList = clubRepository.findAll();
        return ResponseEntity.ok(clubList);

    }

    @GetMapping("/{clubId}")
    public ResponseEntity<Club> getClubById(@PathVariable UUID clubId) {

        try {
            Club club = clubRepository.findById(clubId).orElseThrow();
            return ResponseEntity.ok(club);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping
    public ResponseEntity<?> createClub(@RequestBody ClubCreateDto clubCreateDto) {

        if (clubRepository.existsByName(clubCreateDto.getName())){
            return ResponseEntity.badRequest().build();
        }
        Club club = new Club(clubCreateDto.getName(),clubCreateDto.getStreet(),clubCreateDto.getPlz(),clubCreateDto.getHousenumber(),clubCreateDto.getLocation());
        clubRepository.save(club);
        return ResponseEntity.ok(club);
    }








}
