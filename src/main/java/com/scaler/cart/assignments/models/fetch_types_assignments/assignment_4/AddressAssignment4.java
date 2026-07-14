package com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class AddressAssignment4 extends BaseModel {
    private String number;
    private String street;
    private String city;
    private String pincode;
    private String landmark;
    private String state;
    private Boolean isDefault;

    @ManyToMany(mappedBy = "addresses")
    private List<Customer> customers;
}
