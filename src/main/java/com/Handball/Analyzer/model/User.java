package com.Handball.Analyzer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user")
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

    @OneToMany(mappedBy = "user")
    private Set<ClubUser> clubUsers;

    @OneToMany(mappedBy = "user")
    private Set<Action> actions;

    @OneToMany(mappedBy = "user")
    private Set<ConversationMember> conversationMembers;

    @OneToMany(mappedBy = "user")
    private Set<ChatMessage> chatMessages;

    public User() {
    }

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public Set<ClubUser> getClubUsers() {
        return clubUsers;
    }

    public void setClubUsers(Set<ClubUser> clubUsers) {
        this.clubUsers = clubUsers;
    }

    public Set<Action> getActions() {
        return actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }

    public Set<ConversationMember> getConversationMembers() {
        return conversationMembers;
    }

    public void setConversationMembers(Set<ConversationMember> conversationMembers) {
        this.conversationMembers = conversationMembers;
    }

    public Set<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public void setChatMessages(Set<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname) && Objects.equals(email, user.email) && Objects.equals(gender, user.gender) && Objects.equals(password, user.password) && Objects.equals(role, user.role) && Objects.equals(active, user.active) && Objects.equals(settings, user.settings) && Objects.equals(clubUsers, user.clubUsers) && Objects.equals(actions, user.actions) && Objects.equals(conversationMembers, user.conversationMembers) && Objects.equals(chatMessages, user.chatMessages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, email, gender, password, role, active, settings, clubUsers, actions, conversationMembers, chatMessages);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", active=" + active +
                ", settings=" + settings +
                ", clubUsers=" + clubUsers +
                ", actions=" + actions +
                ", conversationMembers=" + conversationMembers +
                ", chatMessages=" + chatMessages +
                '}';
    }
}
