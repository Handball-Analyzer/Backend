package com.Handball.Analyzer.repository;

import com.Handball.Analyzer.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrainingRepository extends JpaRepository<Training, UUID> {
}
