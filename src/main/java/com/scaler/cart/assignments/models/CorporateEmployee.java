package com.scaler.cart.assignments.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class CorporateEmployee {
    @Id
    private Long id;

    private String name;

    private String designation;

    @OneToOne(mappedBy = "employee")
    private CorporateEmailAddress emailAddress;
}
