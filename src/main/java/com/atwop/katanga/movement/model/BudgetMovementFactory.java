package com.atwop.katanga.movement.model;

public class BudgetMovementFactory implements  MovementFactory{
    @Override
    public Movement create(String description, Float amount, String budgetId, String typeMovement) {
        return new BudgetMovement(description, amount, budgetId, typeMovement);
    }
}
