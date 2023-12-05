package com.Handball.Analyzer.repository;

import com.Handball.Analyzer.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameRepository extends JpaRepository<Game, UUID> {
}
