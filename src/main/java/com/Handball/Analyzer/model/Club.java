package com.Handball.Analyzer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String street;
    private Integer plz;
    private Integer housenumber;
    private String location;

    @OneToMany(mappedBy ="club")
    @JsonIgnore
    private Set<Team> teams;

    @OneToMany(mappedBy = "club")
    @JsonIgnore
    private Set<ClubUser> clubuser;

    @OneToMany(mappedBy = "club")
    @JsonIgnore
    private Set<ClubGym>  clubgym;

    public Club() {
    }

    public Club(String name, String street, Integer plz, Integer housenumber, String location) {
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

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Set<ClubUser> getClubuser() {
        return clubuser;
    }

    public void setClubuser(Set<ClubUser> clubuser) {
        this.clubuser = clubuser;
    }

    public Set<ClubGym> getClubgym() {
        return clubgym;
    }

    public void setClubgym(Set<ClubGym> clubgym) {
        this.clubgym = clubgym;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return Objects.equals(id, club.id) && Objects.equals(name, club.name) && Objects.equals(street, club.street) && Objects.equals(plz, club.plz) && Objects.equals(housenumber, club.housenumber) && Objects.equals(location, club.location) && Objects.equals(teams, club.teams) && Objects.equals(clubuser, club.clubuser) && Objects.equals(clubgym, club.clubgym);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, plz, housenumber, location, teams, clubuser, clubgym);
    }

    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", plz=" + plz +
                ", housenumber=" + housenumber +
                ", location='" + location + '\'' +
                ", teams=" + teams +
                ", clubuser=" + clubuser +
                ", clubgym=" + clubgym +
                '}';
    }
}
