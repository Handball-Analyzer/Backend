package com.Handball.Analyzer.controller.webfront;

import com.Handball.Analyzer.model.Gym;
import com.Handball.Analyzer.model.Team;
import com.Handball.Analyzer.model.Training;
import com.Handball.Analyzer.repository.GymRepository;
import com.Handball.Analyzer.repository.TeamRepository;
import com.Handball.Analyzer.repository.TrainingRepository;
import com.Handball.Analyzer.requestDtos.webfront.createDtos.TrainingCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/webfront/v1/training")
public class TrainingController {

    @Autowired
    TrainingRepository trainingRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    GymRepository gymRepository;


    @GetMapping("/{teamId}")
    public ResponseEntity<List<Training>> getTrainingByTeamId(@PathVariable UUID teamId){
            List<Training> trainingList = trainingRepository.findAllByTeamId(teamId);
            return ResponseEntity.ok(trainingList);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TrainingCreateDto trainingCreateDto){
        try {
            Team team = teamRepository.findById(trainingCreateDto.getTeamId()).orElseThrow();
            Gym gym = gymRepository.findById(trainingCreateDto.getTeamId()).orElseThrow();
            if (trainingCreateDto.getStartDateTime().isAfter(LocalDateTime.now())){
                Training training = new Training(trainingCreateDto.getStartDateTime(),gym,team,false);
                trainingRepository.save(training);
            }
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/{trainingId}/cancel")
    public ResponseEntity<?> cancel (@PathVariable UUID trainingId){
        try {
            Training training = trainingRepository.findById(trainingId).orElseThrow();
            training.setCanceled(!training.getCanceled());
            trainingRepository.save(training);
            return ResponseEntity.ok(training);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }




}
