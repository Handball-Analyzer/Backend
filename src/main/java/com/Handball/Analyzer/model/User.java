package com.Handball.Analyzer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private String gender;
    @JsonIgnore
    private String password;
    private String role;
    private Boolean active;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "settings_id", referencedColumnName = "id")
    private Settings settings;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<ClubUser> clubUsers;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Action> actions;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<ConversationMember> conversationMembers;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<ChatMessage> chatMessages;


    public User(String firstname, String lastname, String email, String gender, String password, String role, Settings settings, Boolean active) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.role = role;
        this.settings = settings;
        this.active = active;
    }


}
