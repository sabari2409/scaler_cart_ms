package com.scaler.cart.assignments.services.fetch_types_assignments.assignment_1;

import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_1.Team;
import com.scaler.cart.assignments.repo.fetch_types_assignments.assignment_1.TeamRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TeamService {

    @Autowired
    private TeamRepo teamRepo;

    public Team getTeamDetails(UUID teamId) {
        Optional<Team> teamDetails = this.teamRepo.findById(teamId);
        if (teamDetails.isEmpty()) throw new RuntimeException("Team details not found");
        return teamDetails.get();
    }
}
