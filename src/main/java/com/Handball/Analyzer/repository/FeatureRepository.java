package com.Handball.Analyzer.repository;

import com.Handball.Analyzer.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FeatureRepository extends JpaRepository<Feature, UUID> {
}
