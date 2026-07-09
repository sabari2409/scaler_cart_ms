package com.scaler.cart.assignments.models.springjparepo_assign3;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("BLOG")
public class BlogPost extends Publication {
    private String url;
}
