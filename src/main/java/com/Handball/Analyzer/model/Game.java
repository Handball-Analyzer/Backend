package com.Handball.Analyzer.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
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
    public Game() {
    }

    public Game(LocalDateTime datetime, String opponents, Integer score_home, Integer score_opponents, Gym gym, Team team) {
        this.datetime = datetime;
        this.opponents = opponents;
        this.score_home = score_home;
        this.score_opponents = score_opponents;
        this.gym = gym;
        this.team = team;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getOpponents() {
        return opponents;
    }

    public void setOpponents(String opponents) {
        this.opponents = opponents;
    }

    public Integer getScore_home() {
        return score_home;
    }

    public void setScore_home(Integer score_home) {
        this.score_home = score_home;
    }

    public Integer getScore_opponents() {
        return score_opponents;
    }

    public void setScore_opponents(Integer score_opponents) {
        this.score_opponents = score_opponents;
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

    public Set<Action> getActions() {
        return actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) && Objects.equals(datetime, game.datetime) && Objects.equals(opponents, game.opponents) && Objects.equals(score_home, game.score_home) && Objects.equals(score_opponents, game.score_opponents) && Objects.equals(gym, game.gym) && Objects.equals(team, game.team) && Objects.equals(actions, game.actions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datetime, opponents, score_home, score_opponents, gym, team, actions);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", datetime=" + datetime +
                ", opponents='" + opponents + '\'' +
                ", score_home=" + score_home +
                ", score_opponents=" + score_opponents +
                ", gym=" + gym +
                ", team=" + team +
                ", actions=" + actions +
                '}';
    }
}
