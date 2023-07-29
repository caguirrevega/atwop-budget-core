package com.atwop.katanga.budget.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class BudgetRepositoryRequestModel {
    private String id;
    private String userId;
    private Float amount;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
    private LocalDateTime dateClosed;

    public BudgetRepositoryRequestModel(String userId, Float amount) {
        this.userId = userId;
        this.amount = amount;
        this.id = UUID.randomUUID().toString();
        this.dateCreated = LocalDateTime.now();
        this.lastUpdated = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public LocalDateTime getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(LocalDateTime dateClosed) {
        this.dateClosed = dateClosed;
    }
}
