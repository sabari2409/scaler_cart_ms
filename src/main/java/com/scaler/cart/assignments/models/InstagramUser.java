package com.scaler.cart.assignments.models;

import jakarta.persistence.*;


import java.util.*;

@Entity
public class InstagramUser {
    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private Set<InstagramPage> pages = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<InstagramLike> instagramLikes = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<InstagramComment> instagramComments = new ArrayList<>();
}
