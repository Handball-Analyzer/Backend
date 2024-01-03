package com.Handball.Analyzer.repository;

import com.Handball.Analyzer.model.ClubGym;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClubGymRepository extends JpaRepository<ClubGym, UUID> {

    List<ClubGym> findAllByClubId(UUID clubId);
}
