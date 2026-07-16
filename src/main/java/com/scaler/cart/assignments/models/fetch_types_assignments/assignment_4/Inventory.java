package com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Inventory extends BaseModel {

    @OneToOne
    @JoinColumn(name = "item_id")
    @JsonIgnore
    private Item item;

    private Double count;

    private Double orderingCost;

    private Double stockOutCost;
}