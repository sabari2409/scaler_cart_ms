package com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Setter
@Getter
@Entity(name = "Orders")
public class Order extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private Double totalCost;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<ItemDetail> items;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<OrderStateTimeMapping> orderTimeline;
}