package com.scaler.cart.assignments.models.other_assignments;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(callSuper = true)
@AttributeOverride(
        name = "owner",
        column = @Column(name = "account_holder")
)
public class BankAccount extends PurchaseDetails {

    @Id
    protected Long id;

    @Column(name = "bank_name")
    protected String bankName;

    @Column(name = "number")
    protected String number;
}