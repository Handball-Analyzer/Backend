package com.Handball.Analyzer.repository;

import com.Handball.Analyzer.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team, UUID> {
}
