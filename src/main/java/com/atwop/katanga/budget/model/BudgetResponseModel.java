package com.atwop.katanga.budget.model;

public class BudgetResponseModel {
    private String budgetId;
    private String userId;

    public BudgetResponseModel(String budgetId, String userId) {
        this.budgetId = budgetId;
        this.userId = userId;
    }

    public String getBudgetId() {
        return budgetId;
    }

    public String getUserId() {
        return userId;
    }
}
