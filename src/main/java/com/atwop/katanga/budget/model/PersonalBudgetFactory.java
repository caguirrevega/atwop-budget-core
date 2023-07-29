package com.atwop.katanga.budget.model;

public class PersonalBudgetFactory implements BudgetFactory{
    @Override
    public Budget create(Float amount, String userId) {
        return new PersonalBudget(amount, userId);
    }
}
