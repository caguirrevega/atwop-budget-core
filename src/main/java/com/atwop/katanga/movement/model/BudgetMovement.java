package com.atwop.katanga.movement.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class BudgetMovement implements Movement{

    private String id;
    private String description;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
    private Float amount;
    private String typeMovement;
    private String budgetId;

    public BudgetMovement() {
        super();
    }

    public BudgetMovement(String description, Float amount,String budgetId, String typeMovement) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.dateCreated = LocalDateTime.now();
        this.lastUpdated = LocalDateTime.now();
        this.amount = amount;
        this.typeMovement = typeMovement;
        this.budgetId = budgetId;
    }

    @Override
    public String validate() {
        if (amount == null || amount <= 0) {
            return "amount is invalid";
        }
        if (description == null || description.isEmpty()) {
            return "description is invalid";
        }
        if (typeMovement == null || typeMovement.isEmpty()) {
            return "type movement is invalid";
        }

        if (budgetId == null || budgetId.isEmpty()) {
            return "budget is invalid";
        }
        return null;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public Float getAmount() {
        return amount;
    }

    public String getTypeMovement() {
        return typeMovement;
    }

    @Override
    public String getBudgetId() {
        return budgetId;
    }
}
