package com.scaler.cart.assignments.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Class {
    @Id
    private UUID id;

    private String topic;

    @ManyToMany(mappedBy = "classes")
    private Set<Batch> batches;

    @OneToOne
    private Instructor currentInstructor;
}