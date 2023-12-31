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
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    @OneToMany(mappedBy = "conversation")
    private Set<ConversationMember> conversationMembers;

    @OneToMany(mappedBy = "conversation")
    private Set<ChatMessage> chatMessages;

    public Conversation(String title) {
        this.title = title;
    }

}
