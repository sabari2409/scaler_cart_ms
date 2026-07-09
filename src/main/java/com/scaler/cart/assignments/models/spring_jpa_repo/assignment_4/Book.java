package com.scaler.cart.assignments.models.spring_jpa_repo.assignment_4;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("BOOK")
public class Book extends Publication {
    private Integer numberOfPages;

    private Double cost;
}
