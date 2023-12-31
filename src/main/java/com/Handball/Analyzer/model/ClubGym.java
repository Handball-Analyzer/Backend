package com.Handball.Analyzer.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class ClubGym {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;

    public ClubGym(Club club, Gym gym) {
        this.club = club;
        this.gym = gym;
    }


}
