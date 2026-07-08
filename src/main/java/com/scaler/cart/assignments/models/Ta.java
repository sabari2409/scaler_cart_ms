package com.scaler.cart.assignments.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Ta extends ContractualEmployee {
    private Long numberOfHelpRequests;
}
