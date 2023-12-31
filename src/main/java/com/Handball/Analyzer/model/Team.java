package com.Handball.Analyzer.model;

import com.Handball.Analyzer.Enumaration.Season;
import com.Handball.Analyzer.Enumaration.Team.AgeGroup;
import com.Handball.Analyzer.Enumaration.Gender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private AgeGroup ageGroup;
    private Integer number;
    @Enumerated(EnumType.STRING)
    private Season season;

    @ManyToOne()
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    @OneToMany(mappedBy = "team")
    private Set<TeamMember> teamMembers;

    @OneToMany(mappedBy = "team")
    private Set<Game> games;
    @OneToMany(mappedBy = "team")
    private Set<Training> trainings;

    @OneToMany(mappedBy = "team")
    private Set<UsedFeature> usedFeatures;


    public Team(Gender gender, AgeGroup ageGroup, Integer number, Season season, Club club) {
        this.gender = gender;
        this.ageGroup = ageGroup;
        this.number = number;
        this.season = season;
        this.club = club;
    }
}
