package com.scaler.cart.assignments.models.other_assignments;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "account_id")
public class CreditAccount extends Account {

    @OneToMany(mappedBy = "credit")
    private Set<CreditCardJPAAssignment2> creditCard = new HashSet<>();

    @Column(name = "interest_rate")
    private double interestRate;
}


