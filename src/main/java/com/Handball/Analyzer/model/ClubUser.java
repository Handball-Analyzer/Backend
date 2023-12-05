package com.Handball.Analyzer.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;
@Entity
public class ClubUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    public ClubUser() {
    }
    public ClubUser(User user, Club club) {
        this.user = user;
        this.club = club;
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

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClubUser clubUser = (ClubUser) o;
        return Objects.equals(id, clubUser.id) && Objects.equals(user, clubUser.user) && Objects.equals(club, clubUser.club);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, club);
    }

    @Override
    public String toString() {
        return "ClubUser{" +
                "id=" + id +
                ", user=" + user +
                ", club=" + club +
                '}';
    }
}
