package com.Handball.Analyzer.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    private String Message;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "conversation_id", nullable = false)
    private Conversation conversation;

    public ChatMessage() {
    }

    public ChatMessage( String message, LocalDateTime timestamp, User user, Conversation conversation) {
        this.Message = message;
        this.timestamp = timestamp;
        this.user = user;
        this.conversation = conversation;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatMessage that = (ChatMessage) o;
        return Objects.equals(id, that.id) && Objects.equals(Message, that.Message) && Objects.equals(timestamp, that.timestamp) && Objects.equals(user, that.user) && Objects.equals(conversation, that.conversation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Message, timestamp, user, conversation);
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", Message='" + Message + '\'' +
                ", timestamp=" + timestamp +
                ", user=" + user +
                ", conversation=" + conversation +
                '}';
    }
}

