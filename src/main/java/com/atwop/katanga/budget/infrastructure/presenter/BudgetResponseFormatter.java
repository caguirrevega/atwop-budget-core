package com.atwop.katanga.budget.infrastructure.presenter;

import com.atwop.katanga.budget.model.BudgetPresenter;
import com.atwop.katanga.budget.model.BudgetResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BudgetResponseFormatter implements BudgetPresenter {
    @Override
    public BudgetResponseModel prepareSuccessResponse(String id, String userId) {
        return new BudgetResponseModel(id, userId);
    }

    @Override
    public BudgetResponseModel prepareFailResponse(String error) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, error);
    }
}
