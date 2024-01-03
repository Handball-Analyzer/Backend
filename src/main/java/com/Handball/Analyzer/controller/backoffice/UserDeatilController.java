package com.Handball.Analyzer.controller.backoffice;

import com.Handball.Analyzer.model.Club;
import com.Handball.Analyzer.model.ClubUser;
import com.Handball.Analyzer.model.Team;
import com.Handball.Analyzer.model.TeamMember;
import com.Handball.Analyzer.repository.ClubUserRepository;
import com.Handball.Analyzer.repository.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/backoffice/v1/userdetails")
public class UserDeatilController {

    @Autowired
    ClubUserRepository clubUserRepository;
    @Autowired
    TeamMemberRepository teamMemberRepository;
    @GetMapping("/{userId}/clubs")
    public ResponseEntity<?> getClubsByUserId(@PathVariable UUID userId){
        List<ClubUser> clubUserList = clubUserRepository.findAllByUserId(userId);
        List<Club> clubList = new ArrayList<>();
        for (ClubUser clubUser : clubUserList) {
            clubList.add(clubUser.getClub());
        }
        return ResponseEntity.ok(clubList);
    }

    @GetMapping("/{userId}/teams")
    public ResponseEntity<?> getTeamsByUserId(@PathVariable UUID userId){
        List<TeamMember> teamMembersList = teamMemberRepository.findAllByUserId(userId);
        List<Team> teamList = new ArrayList<>();
        for (TeamMember teamMember : teamMembersList) {
            teamList.add(teamMember.getTeam());
        }
        return ResponseEntity.ok(teamList);
    }
}
