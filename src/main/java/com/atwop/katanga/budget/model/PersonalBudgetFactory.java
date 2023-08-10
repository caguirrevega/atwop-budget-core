package com.atwop.katanga.budget.model;

import com.atwop.katanga.movement.model.Movement;

import java.util.List;

public class PersonalBudgetFactory implements BudgetFactory{
    @Override
    public Budget create(Float amount, String userId, List<Movement> movements) {
        return new PersonalBudget(amount, userId, movements);
    }
}
