package com.scaler.cart.assignments.models.other_assignments;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PayLater extends PurchaseDetails {

    @Id
    protected Long id;
}
