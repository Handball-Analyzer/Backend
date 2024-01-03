package com.Handball.Analyzer.controller.backoffice;

import com.Handball.Analyzer.model.ClubGym;
import com.Handball.Analyzer.model.Gym;
import com.Handball.Analyzer.repository.ClubGymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/backoffice/v1/clubdetails")
public class ClubDeatilController {

    @Autowired
    ClubGymRepository clubGymRepository;

    @GetMapping("/{clubId}/gyms")
    public ResponseEntity<?> getGymById(@PathVariable UUID clubId){
        List<ClubGym> clubGymList = clubGymRepository.findAllByClubId(clubId);
        List<Gym> gymList = new ArrayList<>();
        for(ClubGym clubGym : clubGymList) {
            gymList.add(clubGym.getGym());
        }
        System.out.println(gymList);
        return ResponseEntity.ok(gymList);
    }
}
