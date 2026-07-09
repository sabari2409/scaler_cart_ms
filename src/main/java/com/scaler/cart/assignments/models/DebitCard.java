package com.scaler.cart.assignments.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class DebitCard {

    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "debit_account_id")
    private DebitAccount debit;
}