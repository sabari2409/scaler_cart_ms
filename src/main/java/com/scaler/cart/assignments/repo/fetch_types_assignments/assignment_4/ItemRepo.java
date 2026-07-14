package com.scaler.cart.assignments.repo.fetch_types_assignments.assignment_4;

import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item,Long> {
}