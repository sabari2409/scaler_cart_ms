package com.scaler.cart.assignments.models.other_assignments;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
public class Student {
    @Id
    private Long id;

    private String name;

//    @OneToMany(mappedBy = "students")
//    private Set<Teacher> teachers;

    @ManyToMany
    @JoinTable(
            name = "students_teachers",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private Set<Teacher> teachers = new HashSet<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<TeacherRating> ratings;
}
