package com.scaler.cart.assignments.dtos;

import com.scaler.cart.assignments.models.CashFlow;
import lombok.Data;

import java.util.List;

@Data
public class RealTimeCashFlowData {
    private List<CashFlow> cash_flow;
}