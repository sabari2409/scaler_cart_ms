package com.scaler.cart.assignments.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRating {

    @EmbeddedId
    private StudentTeacherRatingId studentTeacherRatingId;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    private int rating;
}
