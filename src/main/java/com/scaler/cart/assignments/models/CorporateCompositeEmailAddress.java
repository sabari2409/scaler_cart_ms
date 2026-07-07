package com.scaler.cart.assignments.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CorporateCompositeEmailAddress {

    @EmbeddedId
    private CompanyCompositeId companyCompositeId;

    private String emailAddress;

    @OneToOne
    @MapsId
    @JoinColumns({
            @JoinColumn(name = "company_id", referencedColumnName = "companyId"),
            @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    })
    private CorporateCompositeEmployee employee;
}
