package com.Handball.Analyzer.repository;

import com.Handball.Analyzer.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClubRepository extends JpaRepository<Club, UUID> {

    Boolean existsByName(String name);


}
