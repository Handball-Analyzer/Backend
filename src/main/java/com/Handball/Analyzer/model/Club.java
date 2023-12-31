package com.Handball.Analyzer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String street;
    private Integer plz;
    private Integer housenumber;
    private String location;

    @OneToMany(mappedBy = "club")
    @JsonIgnore
    private Set<Team> teams;

    @OneToMany(mappedBy = "club")
    @JsonIgnore
    private Set<ClubUser> clubuser;

    @OneToMany(mappedBy = "club")
    @JsonIgnore
    private Set<ClubGym> clubgym;


    public Club(String name, String street, Integer plz, Integer housenumber, String location) {
        this.name = name;
        this.street = street;
        this.plz = plz;
        this.housenumber = housenumber;
        this.location = location;
    }


}
