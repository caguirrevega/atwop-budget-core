package com.atwop.katanga.budget.model;


import com.atwop.katanga.movement.model.MovementRequestModel;

import java.util.List;

public class BudgetRequestModel {

    private String userId;
    private Float amount;
    private List<MovementRequestModel> movements;

    public BudgetRequestModel(String userId, Float amount, List<MovementRequestModel> movements) {
        this.userId = userId;
        this.amount = amount;
        this.movements = movements;
    }

    public String getUserId() {
        return userId;
    }

    public Float getAmount() {
        return amount;
    }

    public List<MovementRequestModel> getMovements() {
        return movements;
    }
}
