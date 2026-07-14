package com.scaler.cart.assignments.repo.fetch_types_assignments.assignment_3;

import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_3.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
}