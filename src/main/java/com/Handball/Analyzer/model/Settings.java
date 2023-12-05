package com.Handball.Analyzer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;
@Entity
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

    public Settings() {
    }
    public Settings( String language, String color_mode, String theme, String news) {
        this.language = language;
        this.color_mode = color_mode;
        this.theme = theme;
        this.news = news;
    }
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getColor_mode() {
        return color_mode;
    }

    public void setColor_mode(String color_mode) {
        this.color_mode = color_mode;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Settings settings = (Settings) o;
        return Objects.equals(id, settings.id) && Objects.equals(language, settings.language) && Objects.equals(color_mode, settings.color_mode) && Objects.equals(theme, settings.theme) && Objects.equals(news, settings.news) && Objects.equals(user, settings.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, language, color_mode, theme, news, user);
    }

    @Override
    public String toString() {
        return "Settings{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", color_mode='" + color_mode + '\'' +
                ", theme='" + theme + '\'' +
                ", news='" + news + '\'' +
                ", user=" + user +
                '}';
    }
}
