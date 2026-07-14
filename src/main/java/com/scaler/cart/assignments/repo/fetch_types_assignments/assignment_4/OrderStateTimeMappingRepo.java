package com.scaler.cart.assignments.repo.fetch_types_assignments.assignment_4;

import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4.Order;
import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4.OrderStateTimeMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderStateTimeMappingRepo extends JpaRepository<OrderStateTimeMapping, Long> {
    Optional<OrderStateTimeMapping> findByOrder(Order order);
}