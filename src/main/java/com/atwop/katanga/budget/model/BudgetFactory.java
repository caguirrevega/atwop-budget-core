package com.atwop.katanga.budget.model;

import com.atwop.katanga.movement.model.Movement;

import java.util.List;

public interface BudgetFactory {
    Budget create(Float amount, String userId, List<Movement> movements);
}
