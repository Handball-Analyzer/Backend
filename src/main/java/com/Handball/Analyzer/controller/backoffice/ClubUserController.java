package com.Handball.Analyzer.controller.backoffice;

import com.Handball.Analyzer.model.Club;
import com.Handball.Analyzer.model.ClubUser;
import com.Handball.Analyzer.model.User;
import com.Handball.Analyzer.repository.ClubRepository;
import com.Handball.Analyzer.repository.ClubUserRepository;
import com.Handball.Analyzer.repository.UserRepository;
import com.Handball.Analyzer.requestDtos.backoffice.ClubUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/backoffice/v1/clubuser")
public class ClubUserController {

    @Autowired
    ClubUserRepository clubUserRepository;
    @Autowired
    ClubRepository clubRepository;
    @Autowired
    UserRepository userRepository;

    @PutMapping
    public ResponseEntity<?> create(@RequestBody ClubUserDto clubUserDto){
        try {
            boolean exists = clubUserRepository.existsByClub_IdAndUser_Id(clubUserDto.getClubId(),clubUserDto.getUserId());
            if (!exists){
                Club club = clubRepository.findById(clubUserDto.getClubId()).orElseThrow();
                User user = userRepository.findById(clubUserDto.getUserId()).orElseThrow();
                ClubUser clubUser = new ClubUser(user,club);
                clubUserRepository.save(clubUser);
                return ResponseEntity.status(201).body(clubUser);
            }
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }



    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody ClubUserDto clubUserDto){
        System.out.println(clubUserDto);
        try {
            boolean exists = clubUserRepository.existsByClub_IdAndUser_Id(clubUserDto.getClubId(),clubUserDto.getUserId());
            if (exists){
                ClubUser clubUser = clubUserRepository.findByClub_IdAndUser_Id(clubUserDto.getClubId(),clubUserDto.getUserId());
                clubUserRepository.delete(clubUser);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }
}
