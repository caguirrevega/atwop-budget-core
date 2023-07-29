package com.atwop.katanga.budget.model;

import com.atwop.katanga.budget.model.Budget;

public interface BudgetFactory {
    Budget create(Float amount, String userId);
}
