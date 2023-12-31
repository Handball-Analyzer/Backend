package com.Handball.Analyzer.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
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


    public ChatMessage( String message, LocalDateTime timestamp, User user, Conversation conversation) {
        this.Message = message;
        this.timestamp = timestamp;
        this.user = user;
        this.conversation = conversation;
    }


}

