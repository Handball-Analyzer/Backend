package com.Handball.Analyzer.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
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


    public Action(LocalDateTime created_at, User user, Game game, ActionTyp actionTyp) {
        this.created_at = created_at;
        this.user = user;
        this.game = game;
        this.actionTyp = actionTyp;
    }


}
