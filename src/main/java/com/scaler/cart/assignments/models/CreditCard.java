package com.scaler.cart.assignments.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AttributeOverride(
        name = "owner",
        column = @Column(name = "credit_card_owner")
)
public class CreditCard extends PurchaseDetails {

    @Id
    protected Long id;

    @Column(name = "card_number")
    protected String cardNumber;

    @Column(name = "credit_limit")
    protected Long creditLimit;
}
