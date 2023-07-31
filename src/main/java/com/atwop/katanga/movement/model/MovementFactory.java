package com.atwop.katanga.movement.model;

public interface MovementFactory {
    Movement create(String description, Float amount, String budgetId, String typeMovement);
}
