package com.atwop.katanga.budget.usecase;

import com.atwop.katanga.budget.model.Budget;
import com.atwop.katanga.budget.model.BudgetFactory;
import com.atwop.katanga.budget.model.BudgetInputBoundary;
import com.atwop.katanga.budget.model.BudgetPresenter;
import com.atwop.katanga.budget.model.BudgetRepositoryGateway;
import com.atwop.katanga.budget.model.BudgetRepositoryModel;
import com.atwop.katanga.budget.model.BudgetRequestModel;
import com.atwop.katanga.budget.model.BudgetResponseModel;

public class BudgetCreationUseCase implements BudgetInputBoundary {

    private final BudgetPresenter presenter;
    private final BudgetRepositoryGateway repositoryGateway;
    private final BudgetFactory budgetFactory;

    public BudgetCreationUseCase(BudgetPresenter presenter, BudgetRepositoryGateway repositoryGateway, BudgetFactory budgetFactory) {
        this.presenter = presenter;
        this.repositoryGateway = repositoryGateway;
        this.budgetFactory = budgetFactory;
    }


    @Override
    public BudgetResponseModel create(BudgetRequestModel budgetRequestModel) {
        Budget budget = budgetFactory.create(budgetRequestModel.getAmount(), budgetRequestModel.getUserId());
        String messageErrorValidation = budget.validate();
        if (messageErrorValidation != null) {
             return presenter.prepareFailResponse(messageErrorValidation);
        }
        BudgetRepositoryModel budgetRepositoryModel = new BudgetRepositoryModel(
                budget.getId(), budget.getUserId(), budget.getAmount(), budget.getDateCreated(),
                budget.getLastUpdated(), budget.getDateClosed());

        repositoryGateway.save(budgetRepositoryModel);

        return presenter.prepareSuccessResponse(budgetRepositoryModel.getId(),
                budgetRepositoryModel.getUserId());
    }
}
