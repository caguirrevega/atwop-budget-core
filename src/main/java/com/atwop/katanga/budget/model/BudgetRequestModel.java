package com.atwop.katanga.budget.model;


public class BudgetRequestModel {

    private String userId;
    private Float amount;

    public BudgetRequestModel(String userId, Float amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public Float getAmount() {
        return amount;
    }
}
