package com.scaler.cart.assignments.models.spring_jpa_repo.assignment_5;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Subscription {

    @Id
    protected Long id;

    protected double charges;

    @Enumerated(EnumType.ORDINAL)
    protected Status status;

    @OneToMany(mappedBy = "subscription")
    private List<ProductAssignment$> products;
}
