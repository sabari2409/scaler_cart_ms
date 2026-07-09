package com.scaler.cart.assignments.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class CreditCardJPAAssignment2 {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "credit_account_id")
    private CreditAccount credit;
}
