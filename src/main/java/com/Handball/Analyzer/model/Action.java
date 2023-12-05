package com.Handball.Analyzer.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    @ManyToOne
    @JoinColumn(name = "actionTyp_id", nullable = false)
    private ActionTyp actionTyp;

    public Action() {
    }

    public Action(LocalDateTime created_at, User user, Game game, ActionTyp actionTyp) {
        this.created_at = created_at;
        this.user = user;
        this.game = game;
        this.actionTyp = actionTyp;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public ActionTyp getActionTyp() {
        return actionTyp;
    }

    public void setActionTyp(ActionTyp actionTyp) {
        this.actionTyp = actionTyp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return Objects.equals(id, action.id) && Objects.equals(created_at, action.created_at) && Objects.equals(user, action.user) && Objects.equals(game, action.game) && Objects.equals(actionTyp, action.actionTyp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created_at, user, game, actionTyp);
    }

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", created_at=" + created_at +
                ", user=" + user +
                ", game=" + game +
                ", actionTyp=" + actionTyp +
                '}';
    }
}
