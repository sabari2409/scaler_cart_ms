package com.scaler.cart.assignments.models.fetch_types_assignments.assignment_3;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long number;
    private String street;
    private String city;
    private String landmark;
    private String state;
    private String pincode;

    @ManyToMany(mappedBy = "addresses")
    private List<Person> persons;
}