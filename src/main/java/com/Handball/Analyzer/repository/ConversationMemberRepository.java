package com.Handball.Analyzer.repository;

import com.Handball.Analyzer.model.ConversationMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConversationMemberRepository extends JpaRepository<ConversationMember, UUID> {
}
