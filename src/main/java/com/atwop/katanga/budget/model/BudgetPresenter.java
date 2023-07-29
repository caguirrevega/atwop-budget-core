package com.atwop.katanga.budget.model;

public interface BudgetPresenter {
    BudgetResponseModel prepareSuccessResponse (String id, String userId);
    BudgetResponseModel prepareFailResponse (String error);
}
