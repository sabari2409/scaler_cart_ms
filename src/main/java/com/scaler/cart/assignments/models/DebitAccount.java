package com.scaler.cart.assignments.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "account_id")
public class DebitAccount extends Account {

    @OneToOne(mappedBy = "debit")
    private DebitCard debitCard;

    @Column(name = "balance")
    private double balance;
}
