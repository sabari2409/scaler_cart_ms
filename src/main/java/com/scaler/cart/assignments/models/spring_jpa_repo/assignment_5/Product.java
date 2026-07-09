package com.scaler.cart.assignments.models.spring_jpa_repo.assignment_5;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Product {

    @Id
    protected Long id;

    protected String name;

    @Enumerated(EnumType.STRING)
    protected Status status;

    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;
}

/**
 * Subscription
 * ▲
 * │
 * Many Products
 * │
 * Product
 * -------------------
 * id
 * name
 * status
 * subscription_id
 * ▲
 * --------|--------
 * |               |
 * Book            Pen
 **/