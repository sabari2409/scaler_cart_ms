package com.scaler.cart.assignments.models;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
public class CompanyCompositeId {
    private Long companyId;
    private Long employeeId;
}
