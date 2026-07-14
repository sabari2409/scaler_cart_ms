package com.scaler.cart.assignments.models.fetch_types_assignments.assignment_2;


import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel {
    @Id
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private State state;
}
