package com.Handball.Analyzer.repository;

import com.Handball.Analyzer.model.ActionTyp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActionTypRepository extends JpaRepository<ActionTyp, UUID> {
}
