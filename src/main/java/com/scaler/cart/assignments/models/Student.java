package com.scaler.cart.assignments.models;

import jakarta.persistence.*;

import java.util.Set;


@Entity
public class Student {
    @Id
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Set<Teacher> teachers;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<TeacherRating> ratings;
}
