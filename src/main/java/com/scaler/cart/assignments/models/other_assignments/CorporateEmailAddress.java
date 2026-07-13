package com.scaler.cart.assignments.models.other_assignments;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class CorporateEmailAddress {
    @Id
    private Long id;

    private String tenant;

    private Date createdAt;

    @OneToOne
    @MapsId
    @JoinColumn(name = "employee_id")
    private CorporateEmployee employee;
}


/**
 * You are given with 2 models - CorporateEmployee and CorporateEmailAddress. Fields are already present in these models.
 * You need to define cardinalities like @ManyToOne, @OneToOne in these models and make sure tables are also created for these classes.
 * Also instead of creating new column corporate_email_address_id, we want to mark the Primary Key column employee_id of corporateemailaddress table
 * as the foreign key to corporate_employee table. This way, we will optimize the storage space. This is known as Shared Primary Key.
 */