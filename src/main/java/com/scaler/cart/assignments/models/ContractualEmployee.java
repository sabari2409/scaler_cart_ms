package com.scaler.cart.assignments.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(callSuper = true)
public class ContractualEmployee extends Employee {
    @Id
    private String alias;

    @Column(name = "hourly_renumeration")
    private Double hourlyRenumeration;
}

