package com.Handball.Analyzer.repository;

import com.Handball.Analyzer.model.UseRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface UseRequestRepository extends JpaRepository<UseRequest, UUID> {

    List<UseRequest> findAllByClubName(String clubName);




}
