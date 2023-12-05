package com.Handball.Analyzer.repository;

import com.Handball.Analyzer.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GymRepository extends JpaRepository<Gym, UUID> {
}
