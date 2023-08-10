package com.atwop.katanga.report.model;

import java.util.Optional;

public class ReportRequestModel {

    private String budgetId;

    public ReportRequestModel(String budgetId) {
        this.budgetId = budgetId;
    }


    public Optional<String> validate() {
        if (budgetId == null || budgetId.isEmpty() || budgetId.isBlank()) {
            return Optional.of("budgetId is invalid");
        }

        return Optional.empty();
    }

    public String getBudgetId() {
        return budgetId;
    }
}
