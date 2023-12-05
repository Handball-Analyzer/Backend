package com.Handball.Analyzer.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
public class ActionTyp {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String Name_en;

    private String Name_de;

    @OneToMany(mappedBy = "actionTyp")
    private Set<Action> actions;

    public ActionTyp() {
    }

    public ActionTyp(String name_en, String name_de) {
        Name_en = name_en;
        Name_de = name_de;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName_en() {
        return Name_en;
    }

    public void setName_en(String name_en) {
        Name_en = name_en;
    }

    public String getName_de() {
        return Name_de;
    }

    public void setName_de(String name_de) {
        Name_de = name_de;
    }

    public Set<Action> getActions() {
        return actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionTyp actionTyp = (ActionTyp) o;
        return Objects.equals(id, actionTyp.id) && Objects.equals(Name_en, actionTyp.Name_en) && Objects.equals(Name_de, actionTyp.Name_de) && Objects.equals(actions, actionTyp.actions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Name_en, Name_de, actions);
    }

    @Override
    public String toString() {
        return "ActionTyp{" +
                "id=" + id +
                ", Name_en='" + Name_en + '\'' +
                ", Name_de='" + Name_de + '\'' +
                ", actions=" + actions +
                '}';
    }
}
