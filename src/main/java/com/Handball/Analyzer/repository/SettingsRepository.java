package com.Handball.Analyzer.repository;

import com.Handball.Analyzer.model.Settings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SettingsRepository extends JpaRepository<Settings, UUID> {
}
