package com.scaler.cart.assignments.models.fetch_types_assignments.assignment_2;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Image extends BaseModel {
    private String resolution;

    private Long sizeInKb;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private String descriptiveName;
}