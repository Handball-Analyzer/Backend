package com.Handball.Analyzer.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime startDateTime;
    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Training() {
    }

    public Training(LocalDateTime startDateTime, Gym gym, Team team) {
        this.startDateTime = startDateTime;
        this.gym = gym;
        this.team = team;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return Objects.equals(id, training.id) && Objects.equals(startDateTime, training.startDateTime) && Objects.equals(gym, training.gym) && Objects.equals(team, training.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDateTime, gym, team);
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", startDateTime=" + startDateTime +
                ", gym=" + gym +
                ", team=" + team +
                '}';
    }
}
