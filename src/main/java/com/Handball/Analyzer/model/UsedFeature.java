package com.Handball.Analyzer.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;


    @Entity
    @Data
    @NoArgsConstructor
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

        public UsedFeature(Team team, Feature feature) {
            this.team = team;
            this.feature = feature;
        }

    }
