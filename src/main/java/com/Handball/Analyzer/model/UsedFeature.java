package com.Handball.Analyzer.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;


    @Entity
    public class UsedFeature {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @ManyToOne
        @JoinColumn(name = "team_id")
        private Team team;

        @ManyToOne
        @JoinColumn(name = "feature_id")
        private Feature feature;

        public UsedFeature() {
        }

        public UsedFeature(Team team, Feature feature) {
            this.team = team;
            this.feature = feature;
        }

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public Team getTeam() {
            return team;
        }

        public void setTeam(Team team) {
            this.team = team;
        }

        public Feature getFeature() {
            return feature;
        }

        public void setFeature(Feature feature) {
            this.feature = feature;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UsedFeature that = (UsedFeature) o;
            return Objects.equals(id, that.id) && Objects.equals(team, that.team) && Objects.equals(feature, that.feature);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, team, feature);
        }

        @Override
        public String toString() {
            return "UsedFeature{" +
                    "id=" + id +
                    ", team=" + team +
                    ", feature=" + feature +
                    '}';
        }
    }
