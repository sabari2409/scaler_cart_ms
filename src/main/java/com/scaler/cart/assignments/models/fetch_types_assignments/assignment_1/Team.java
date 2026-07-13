package com.scaler.cart.assignments.models.fetch_types_assignments.assignment_1;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Team {

    @Id
    private UUID id;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<Employee> employees;

    private Double budget;

    private String location;
}


/**
 * Team             Employee
 * 1                    M
 * M                    M
 */