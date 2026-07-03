package com.scaler.cart.assignments.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class InstagramPost {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "instagram_page_id", nullable = false)
    private InstagramPage instagramPage;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<InstagramLike> instagramLikes;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<InstagramComment> instagramComments;

    private String content;
}