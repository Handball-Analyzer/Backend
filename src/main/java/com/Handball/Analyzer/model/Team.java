package com.Handball.Analyzer.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String gender;
    private String age_group;
    private Integer number;
    private String season;

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

    public Team() {
    }
    public Team(String gender, String age_group, Integer number,String season, Club club) {
        this.gender = gender;
        this.age_group = age_group;
        this.number = number;
        this.season = season;
        this.club = club;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge_group() {
        return age_group;
    }

    public void setAge_group(String age_group) {
        this.age_group = age_group;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Set<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Set<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public Set<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }

    public Set<UsedFeature> getUsedFeatures() {
        return usedFeatures;
    }

    public void setUsedFeatures(Set<UsedFeature> usedFeatures) {
        this.usedFeatures = usedFeatures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) && Objects.equals(gender, team.gender) && Objects.equals(age_group, team.age_group) && Objects.equals(number, team.number) && Objects.equals(season, team.season) && Objects.equals(club, team.club) && Objects.equals(teamMembers, team.teamMembers) && Objects.equals(games, team.games) && Objects.equals(trainings, team.trainings) && Objects.equals(usedFeatures, team.usedFeatures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gender, age_group, number, season, club, teamMembers, games, trainings, usedFeatures);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", age_group='" + age_group + '\'' +
                ", number=" + number +
                ", season='" + season + '\'' +
                ", club=" + club +
                ", teamMembers=" + teamMembers +
                ", games=" + games +
                ", trainings=" + trainings +
                ", usedFeatures=" + usedFeatures +
                '}';
    }
}
