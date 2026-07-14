package com.scaler.cart.assignments.repo.fetch_types_assignments.assignment_2;

import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_2.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
