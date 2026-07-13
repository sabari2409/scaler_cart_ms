package com.scaler.cart.assignments.repo.fetch_types_assignments.assignment_1;

import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_1.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeamRepo extends JpaRepository<Team, UUID> {
}
