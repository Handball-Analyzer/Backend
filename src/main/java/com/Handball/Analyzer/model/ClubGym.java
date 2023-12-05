package com.Handball.Analyzer.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
public class ClubGym {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;

    public ClubGym() {
    }

    public ClubGym(Club club, Gym gym) {
        this.club = club;
        this.gym = gym;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClubGym clubGym = (ClubGym) o;
        return Objects.equals(id, clubGym.id) && Objects.equals(club, clubGym.club) && Objects.equals(gym, clubGym.gym);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, club, gym);
    }

    @Override
    public String toString() {
        return "ClubGym{" +
                "id=" + id +
                ", club=" + club +
                ", gym=" + gym +
                '}';
    }
}
