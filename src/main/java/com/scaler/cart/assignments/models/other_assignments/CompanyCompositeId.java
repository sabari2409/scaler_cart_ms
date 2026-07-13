package com.scaler.cart.assignments.models.other_assignments;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class CompanyCompositeId {
    private Long companyId;
    private Long employeeId;
}
