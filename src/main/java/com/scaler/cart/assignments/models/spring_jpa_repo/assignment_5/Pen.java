package com.scaler.cart.assignments.models.spring_jpa_repo.assignment_5;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Pen extends Product {

    @Enumerated(EnumType.ORDINAL)
    private PenType penType;
}
