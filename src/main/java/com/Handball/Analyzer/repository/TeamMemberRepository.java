package com.Handball.Analyzer.repository;

import com.Handball.Analyzer.model.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamMemberRepository extends JpaRepository<TeamMember, UUID> {
}
