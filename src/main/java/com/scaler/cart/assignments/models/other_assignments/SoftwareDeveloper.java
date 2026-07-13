package com.scaler.cart.assignments.models.other_assignments;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class SoftwareDeveloper extends PermanentEmployee {
    private Long leavesTaken;
}

