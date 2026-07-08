package com.scaler.cart.assignments.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(callSuper = true)
public class PermanentEmployee extends Employee {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "cost_to_company")
    private Double costToCompany;
}
