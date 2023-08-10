package com.atwop.katanga.budget.usecase;

import com.atwop.katanga.budget.model.Budget;
import com.atwop.katanga.budget.model.BudgetFactory;
import com.atwop.katanga.budget.model.BudgetInputBoundary;
import com.atwop.katanga.budget.model.BudgetPresenter;
import com.atwop.katanga.budget.model.BudgetRepositoryGateway;
import com.atwop.katanga.budget.model.BudgetRepositoryModel;
import com.atwop.katanga.budget.model.BudgetRequestModel;
import com.atwop.katanga.budget.model.BudgetResponseModel;
import com.atwop.katanga.movement.model.BudgetMovement;
import com.atwop.katanga.movement.model.Movement;
import com.atwop.katanga.movement.model.MovementRepositoryRequestModel;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        List<Movement> movementList = Optional.ofNullable(budgetRequestModel.getMovements()).orElse(Collections.emptyList())
                .stream().map(e -> new BudgetMovement(e.getDescription(), e.getAmount(),
                e.getBudgetId(), e.getTypeMovement())).collect(Collectors.toList());

        Budget budget = budgetFactory.create(budgetRequestModel.getAmount(), budgetRequestModel.getUserId(), movementList);

        String messageErrorValidation = budget.validate();
        if (messageErrorValidation != null) {
             return presenter.prepareFailResponse(messageErrorValidation);
        }

        List<MovementRepositoryRequestModel> movementsRepositoryModel = movementList.stream()
                .map(e -> new MovementRepositoryRequestModel(e.getId(),e.getDescription(), e.getAmount(),
                        e.getDateCreated(), e.getLastUpdated(), e.getTypeMovement(), e.getBudgetId()))
                .collect(Collectors.toList());
        BudgetRepositoryModel budgetRepositoryModel = new BudgetRepositoryModel(
                budget.getId(), budget.getUserId(), budget.getAmount(), budget.getDateCreated(),
                budget.getLastUpdated(), budget.getDateClosed(), movementsRepositoryModel);

        repositoryGateway.save(budgetRepositoryModel);

        return presenter.prepareSuccessResponse(budgetRepositoryModel.getId(),
                budgetRepositoryModel.getUserId());
    }
}
