package com.scaler.cart.assignments.repo.fetch_types_assignments.assignment_4;

import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
}