package com.scaler.cart.assignments.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher {
    @Id
    private Long id;

    private String name;

//    @OneToMany(mappedBy = "teachers")
//    private Set<Student> students;


    @ManyToMany(mappedBy = "teachers")
    private Set<Student> students = new HashSet<>();

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TeacherRating> ratings;
}
