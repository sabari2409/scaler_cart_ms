package com.scaler.cart.assignments.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class CorporateCompositeEmployee {

    @EmbeddedId
    private CompanyCompositeId companyCompositeId;

    private String name;

    @OneToOne(mappedBy = "employee")
    private CorporateCompositeEmailAddress corporateCompositeEmailAddress;

}
