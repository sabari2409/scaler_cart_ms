package com.scaler.cart.assignments.models.other_assignments;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class InstructorJPAAssignment2 extends ContractualEmployee {
    private String company;
}
