package com.scaler.cart.assignments.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Message {
    @Id
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Member author;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private WhatsappGroup group;
}
