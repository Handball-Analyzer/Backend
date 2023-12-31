package com.Handball.Analyzer.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime datetime;
    private String opponents;
    private  Integer score_home;
    private Integer score_opponents;

    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "game")
    private Set<Action> actions;


    public Game(LocalDateTime datetime, String opponents, Integer score_home, Integer score_opponents, Gym gym, Team team) {
        this.datetime = datetime;
        this.opponents = opponents;
        this.score_home = score_home;
        this.score_opponents = score_opponents;
        this.gym = gym;
        this.team = team;
    }

}
