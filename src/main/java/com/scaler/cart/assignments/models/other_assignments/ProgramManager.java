package com.scaler.cart.assignments.models.other_assignments;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class ProgramManager extends PermanentEmployee {

    @Column(name = "features_completed")
    private Long featuresCompleted;
}
