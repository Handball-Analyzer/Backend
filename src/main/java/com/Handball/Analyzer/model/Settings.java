package com.Handball.Analyzer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;
@Entity
@Data
@NoArgsConstructor
public class Settings {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;
    private String language;
    private String color_mode;
    private String theme;
    private String news;

    @OneToOne(mappedBy = "settings")
    @JsonIgnore
    private User user;


    public Settings( String language, String color_mode, String theme, String news) {
        this.language = language;
        this.color_mode = color_mode;
        this.theme = theme;
        this.news = news;
    }

}
