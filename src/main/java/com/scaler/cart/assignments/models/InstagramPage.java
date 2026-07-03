package com.scaler.cart.assignments.models;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class InstagramPage {
    @Id
    private UUID id;

    @OneToMany(mappedBy = "instagramPage", cascade = CascadeType.ALL)
    private Set<InstagramPost> posts = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private InstagramUser creator;
}
