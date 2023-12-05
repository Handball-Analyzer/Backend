package com.Handball.Analyzer.repository;

import com.Handball.Analyzer.model.UsedFeature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsedFeatureRepository extends JpaRepository<UsedFeature, UUID> {
}
