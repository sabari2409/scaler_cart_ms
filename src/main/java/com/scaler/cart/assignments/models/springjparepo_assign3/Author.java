package com.scaler.cart.assignments.models.springjparepo_assign3;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
public class Author {
    @Id
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "authors")
    private List<Publication> publications;
}

