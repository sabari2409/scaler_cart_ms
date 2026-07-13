package com.scaler.cart.assignments.models.other_assignments;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Member {
    @Id
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "members")
    private Set<WhatsappGroup> groups = new HashSet<>();

    @OneToMany(mappedBy = "author")
    private List<Message> messages = new ArrayList<>();
}