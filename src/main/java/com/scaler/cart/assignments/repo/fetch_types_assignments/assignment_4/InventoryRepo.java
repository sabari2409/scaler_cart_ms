package com.scaler.cart.assignments.repo.fetch_types_assignments.assignment_4;

import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4.Inventory;
import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findByItem(Item item);

    Inventory save(Inventory inventory);
}