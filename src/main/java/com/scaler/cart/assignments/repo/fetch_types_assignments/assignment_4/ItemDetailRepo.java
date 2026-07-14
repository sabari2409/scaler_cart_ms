package com.scaler.cart.assignments.repo.fetch_types_assignments.assignment_4;

import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4.ItemDetail;
import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemDetailRepo extends JpaRepository<ItemDetail, Long> {
    ItemDetail save(ItemDetail itemDetail);

    Optional<ItemDetail> findByOrder(Order order);
}
