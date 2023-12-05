package com.Handball.Analyzer.repository;

import com.Handball.Analyzer.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActionRepository extends JpaRepository<Action, UUID> {
}
