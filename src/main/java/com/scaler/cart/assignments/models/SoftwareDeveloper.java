package com.scaler.cart.assignments.models;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class SoftwareDeveloper extends PermanentEmployee {
    private Long leavesTaken;
}

