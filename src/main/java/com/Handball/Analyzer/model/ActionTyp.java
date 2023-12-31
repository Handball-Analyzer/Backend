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
public class ActionTyp {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String Name_en;

    private String Name_de;

    @OneToMany(mappedBy = "actionTyp")
    private Set<Action> actions;

    public ActionTyp(String name_en, String name_de) {
        Name_en = name_en;
        Name_de = name_de;
    }


}
