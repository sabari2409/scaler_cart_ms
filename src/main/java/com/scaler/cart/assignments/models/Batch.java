package com.scaler.cart.assignments.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Batch {
    @Id
    private UUID id;

    private String name;

    @ManyToMany(mappedBy = "previousBatches")
    private Set<Learner> learners = new HashSet<>();

    @ManyToMany(mappedBy = "batches")
    private List<Instructor> instructors;


    @ManyToMany
    @JoinTable(
            name = "batches_classes",
            joinColumns = @JoinColumn(name = "batch_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private Set<Class> classes;
}
