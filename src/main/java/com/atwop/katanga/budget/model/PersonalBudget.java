package com.atwop.katanga.budget.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class PersonalBudget implements Budget {
    private String id;
    private Float amount;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
    private LocalDateTime dateClosed;
    private String userId;

    public PersonalBudget() {}

    public PersonalBudget(Float amount, String userId) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.dateCreated = LocalDateTime.now();
        this.lastUpdated = LocalDateTime.now();
        this.userId = userId;
    }

    @Override
    public String validate() {
        if (amount == null || amount <= 0) {
            return "amount is invalid";
        }
        if (userId == null || userId.isEmpty()) {
            return "userId is invalid";
        }
        return null;
    }

    public String getId() {
        return id;
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

    public LocalDateTime getDateClosed() {
        return dateClosed;
    }

    public String getUserId() {
        return userId;
    }
}
