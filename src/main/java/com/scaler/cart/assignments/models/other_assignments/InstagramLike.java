package com.scaler.cart.assignments.models.other_assignments;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class InstagramLike {
    @Id
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "post_id", nullable = false)
    private InstagramPost post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private InstagramUser user;
}
