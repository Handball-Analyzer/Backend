package com.Handball.Analyzer.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;
@Entity
public class ConversationMember {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private Conversation conversation;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private User user;

    public ConversationMember() {
    }

    public ConversationMember(Conversation conversation, User user) {
        this.conversation = conversation;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversationMember that = (ConversationMember) o;
        return Objects.equals(id, that.id) && Objects.equals(conversation, that.conversation) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, conversation, user);
    }

    @Override
    public String toString() {
        return "ConversationMember{" +
                "id=" + id +
                ", conversation=" + conversation +
                ", user=" + user +
                '}';
    }
}
