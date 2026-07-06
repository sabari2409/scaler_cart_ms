package com.scaler.cart.assignments.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Teacher {
    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "teacher")
    private Set<Student> students;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TeacherRating> ratings;
}
