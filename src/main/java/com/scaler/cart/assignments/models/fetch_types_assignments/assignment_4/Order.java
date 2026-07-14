package com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name = "Orders")
public class Order extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private Double totalCost;

    @OneToMany(mappedBy = "order")
    private List<ItemDetail> items;

    @OneToMany(mappedBy = "order")
    private List<OrderStateTimeMapping> orderTimeline;
}