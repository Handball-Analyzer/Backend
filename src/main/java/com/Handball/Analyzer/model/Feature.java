package com.Handball.Analyzer.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String Name;

    @OneToMany(mappedBy = "feature")
    private Set<UsedFeature> usedFeatures;

    public Feature(String name) {
        Name = name;
    }


}
