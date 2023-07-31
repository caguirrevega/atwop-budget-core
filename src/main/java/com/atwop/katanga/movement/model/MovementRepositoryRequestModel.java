package com.atwop.katanga.movement.model;

import java.time.LocalDateTime;

public class MovementRepositoryRequestModel {

    private String id;
    private String description;
    private Float amount;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
    private String typeMovement;
    private String budgetId;


    public MovementRepositoryRequestModel(String id, String description, Float amount, LocalDateTime dateCreated, LocalDateTime lastUpdated, String typeMovement, String budgetId) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
        this.typeMovement = typeMovement;
        this.budgetId = budgetId;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Float getAmount() {
        return amount;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public String getTypeMovement() {
        return typeMovement;
    }

    public String getBudgetId() {
        return budgetId;
    }
}
