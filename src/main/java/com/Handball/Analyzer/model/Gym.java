package com.Handball.Analyzer.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String street;
    private Integer plz;
    private Integer housenumber;
    private String location;

    @OneToMany(mappedBy = "gym")
    private Set<ClubGym> clubGym;
    @OneToMany(mappedBy = "gym")
    private Set<Game> games;

    @OneToMany(mappedBy = "gym")
    private Set<Training> trainings;

    public Gym() {
    }

    public Gym(String name, String street, Integer plz, Integer housenumber, String location) {
        this.name = name;
        this.street = street;
        this.plz = plz;
        this.housenumber = housenumber;
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getPlz() {
        return plz;
    }

    public void setPlz(Integer plz) {
        this.plz = plz;
    }

    public Integer getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(Integer housenumber) {
        this.housenumber = housenumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<ClubGym> getClubGym() {
        return clubGym;
    }

    public void setClubGym(Set<ClubGym> clubGym) {
        this.clubGym = clubGym;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gym gym = (Gym) o;
        return Objects.equals(id, gym.id) && Objects.equals(name, gym.name) && Objects.equals(street, gym.street) && Objects.equals(plz, gym.plz) && Objects.equals(housenumber, gym.housenumber) && Objects.equals(location, gym.location) && Objects.equals(clubGym, gym.clubGym) && Objects.equals(games, gym.games) && Objects.equals(trainings, gym.trainings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, plz, housenumber, location, clubGym, games, trainings);
    }

    @Override
    public String toString() {
        return "Gym{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", plz=" + plz +
                ", housenumber=" + housenumber +
                ", location='" + location + '\'' +
                ", clubGym=" + clubGym +
                ", games=" + games +
                ", trainings=" + trainings +
                '}';
    }
}
