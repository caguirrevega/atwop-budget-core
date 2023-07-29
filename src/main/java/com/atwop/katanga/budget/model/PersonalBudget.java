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
        String messageError = null;
        if (amount == null || amount <= 0) {
            messageError = "amount is invalid";
        }
        if (userId == null || userId.isEmpty()) {
            messageError = "userId is invalid";
        }
        return messageError;
    }
}
