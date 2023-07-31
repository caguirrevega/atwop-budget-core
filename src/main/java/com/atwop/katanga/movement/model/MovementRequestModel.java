package com.atwop.katanga.movement.model;

public class MovementRequestModel {
    private String description;
    private Float amount;
    private String typeMovement;
    private String budgetId;

    public String getDescription() {
        return description;
    }

    public Float getAmount() {
        return amount;
    }

    public String getTypeMovement() {
        return typeMovement;
    }

    public String getBudgetId() {
        return budgetId;
    }
}
