package com.scaler.cart.assignments.models.other_assignments;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher {
    @Id
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "teachers")
    private Set<Student> students = new HashSet<>();

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TeacherRating> ratings;
}
