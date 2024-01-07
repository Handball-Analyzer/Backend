package com.Handball.Analyzer.repository;

import com.Handball.Analyzer.model.ClubUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClubUserRepository extends JpaRepository<ClubUser, UUID> {
    Boolean existsByClub_IdAndUser_Id(UUID clubId,UUID userId);

    List<ClubUser> findAllByUserId(UUID userId);
    ClubUser findByClub_IdAndUser_Id(UUID clubId,UUID userId);
}
