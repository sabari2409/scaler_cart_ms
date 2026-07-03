package com.scaler.cart.assignments.models;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class InstagramComment {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private InstagramPost post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private InstagramUser user;

    @Column
    private String text;
}