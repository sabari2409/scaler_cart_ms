package com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Item extends BaseModel {

    private String title;
    private String description;
    private String imageUrl;
    private Double price;
    private Boolean isPremium;

    @OneToOne(mappedBy = "item", fetch = FetchType.LAZY)
    private Inventory inventory;
}

