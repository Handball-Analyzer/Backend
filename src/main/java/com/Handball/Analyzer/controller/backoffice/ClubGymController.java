package com.Handball.Analyzer.controller.backoffice;

import com.Handball.Analyzer.model.Club;
import com.Handball.Analyzer.model.ClubGym;
import com.Handball.Analyzer.model.Gym;
import com.Handball.Analyzer.repository.ClubGymRepository;
import com.Handball.Analyzer.repository.ClubRepository;
import com.Handball.Analyzer.requestDtos.backoffice.CreateGymDto;
import com.Handball.Analyzer.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/backoffice/v1/clubgym")
public class ClubGymController {

    @Autowired
    GymService gymService;
    @Autowired
    ClubRepository clubRepository;
    @Autowired
    ClubGymRepository clubGymRepository;
    @PostMapping("{clubId}")
    public ResponseEntity createGymbyClub(@RequestBody CreateGymDto createGymDto, @PathVariable UUID clubId){
        try {
            Gym gym = gymService.createGym(createGymDto);
            Club club = clubRepository.findById(clubId).orElseThrow();
            ClubGym clubGym = new ClubGym(club, gym);
            clubGymRepository.save(clubGym);
            return ResponseEntity.ok(clubGym);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }



    }

}
