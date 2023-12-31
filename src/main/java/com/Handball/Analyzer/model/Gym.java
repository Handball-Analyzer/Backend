package com.Handball.Analyzer.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String street;
    private Integer plz;
    private Integer housenumber;
    private String location;

    @OneToMany(mappedBy = "gym")
    private Set<ClubGym> clubGym;
    @OneToMany(mappedBy = "gym")
    private Set<Game> games;

    @OneToMany(mappedBy = "gym")
    private Set<Training> trainings;

    public Gym(String name, String street, Integer plz, Integer housenumber, String location) {
        this.name = name;
        this.street = street;
        this.plz = plz;
        this.housenumber = housenumber;
        this.location = location;
    }

}
