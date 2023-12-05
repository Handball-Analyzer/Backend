package com.Handball.Analyzer.repository;

import com.Handball.Analyzer.model.ClubUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClubUserRepository extends JpaRepository<ClubUser, UUID> {
}
