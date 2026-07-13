package com.scaler.cart.assignments.models.other_assignments;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class StudentsTeachers implements Serializable {

    private Long studentId;
    private Long teacherId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentsTeachers)) return false;
        StudentsTeachers that = (StudentsTeachers) o;
        return Objects.equals(studentId, that.studentId)
                && Objects.equals(teacherId, that.teacherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, teacherId);
    }
}
