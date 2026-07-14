package com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class OrderStateTimeMapping extends BaseModel {

    @Enumerated(EnumType.ORDINAL)
    private OrderState orderState = OrderState.CONFIRMED;

    private Date date = new Date();

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}