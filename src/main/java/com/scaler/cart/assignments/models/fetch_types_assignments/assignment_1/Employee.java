package com.scaler.cart.assignments.models.fetch_types_assignments.assignment_1;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double costToCompany;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    List<IdentityProof> proofs;
}
