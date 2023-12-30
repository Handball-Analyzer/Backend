package com.Handball.Analyzer.controller.backoffice;

import com.Handball.Analyzer.model.Club;
import com.Handball.Analyzer.repository.ClubRepository;
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
    public ResponseEntity<List<Club>> getAllClubs(){
        List<Club> clubList = clubRepository.findAll();

        if (clubList.isEmpty()){
            return ResponseEntity.status(204).body(null);
        }else {
            return ResponseEntity.status(200).body(clubList);
        }
    }
    @GetMapping("/{userId}")
    public ResponseEntity<Optional<Club>> getClubById(@PathVariable UUID clubId){

        Optional<Club> club = clubRepository.findById(clubId);
        if (club.isEmpty()){
            return ResponseEntity.status(404).body(null);
        }else {
            return ResponseEntity.status(200).body(club);
        }
    }

    @PostMapping
    public ResponseEntity<?> createClub(@RequestBody Club club){
        // TODO: Implement
        return ResponseEntity.status(204).body(null);
    }




}
