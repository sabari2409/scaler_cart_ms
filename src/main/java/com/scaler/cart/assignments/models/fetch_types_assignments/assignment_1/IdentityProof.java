package com.scaler.cart.assignments.models.fetch_types_assignments.assignment_1;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class IdentityProof {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
}
