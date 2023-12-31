package com.Handball.Analyzer.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime startDateTime;

    private Boolean canceled;
    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;



    public Training(LocalDateTime startDateTime, Gym gym, Team team, Boolean canceled) {
        this.startDateTime = startDateTime;
        this.gym = gym;
        this.team = team;
        this.canceled = canceled;
    }


}
