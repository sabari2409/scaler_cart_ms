package com.scaler.cart.assignments.models.fetch_types_assignments.assignment_2;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseModel {

    private String title;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Product> productList;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @BatchSize(size = 3)
    private List<SubCategory> subCategories;
}
