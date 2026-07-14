package com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ItemDetail extends BaseModel {

    @OneToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
