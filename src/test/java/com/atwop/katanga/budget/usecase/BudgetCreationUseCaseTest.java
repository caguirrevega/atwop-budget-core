package com.atwop.katanga.budget.usecase;

import com.atwop.katanga.budget.model.BudgetFactory;
import com.atwop.katanga.budget.model.BudgetPresenter;
import com.atwop.katanga.budget.model.BudgetRepositoryGateway;
import com.atwop.katanga.budget.model.BudgetRepositoryModel;
import com.atwop.katanga.budget.model.BudgetRequestModel;
import com.atwop.katanga.budget.model.PersonalBudget;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BudgetCreationUseCaseTest {

    BudgetPresenter presenter = mock(BudgetPresenter.class);
    BudgetRepositoryGateway budgetRepositoryGateway = mock(BudgetRepositoryGateway.class);
    BudgetFactory budgetFactory = mock(BudgetFactory.class);

    BudgetCreationUseCase budgetCreationUseCase = new BudgetCreationUseCase(presenter, budgetRepositoryGateway, budgetFactory);

    @Test
    void givenBudgetWhenIsInvalidThenPrepareFailResponse() {
        BudgetRequestModel budgetRequestModel = new BudgetRequestModel(null, 300F);
        when(budgetFactory.create(any(Float.class), any())).thenReturn(
                new PersonalBudget(budgetRequestModel.getAmount(), budgetRequestModel.getUserId()));
        budgetCreationUseCase.create(budgetRequestModel);

        verify(presenter, times(1)).prepareFailResponse(anyString());
        verify(budgetFactory, times(1)).create(any(Float.class), any());

    }

    @Test
    void givenBudgetWhenIsValidThenPrepareSuccessfulResponse() {
        BudgetRequestModel budgetRequestModel = new BudgetRequestModel("123", 300F);
        when(budgetFactory.create(any(Float.class), any())).thenReturn(
                new PersonalBudget(budgetRequestModel.getAmount(), budgetRequestModel.getUserId()));
        budgetCreationUseCase.create(budgetRequestModel);

        verify(presenter, times(1)).prepareSuccessResponse(anyString(), anyString());
        verify(budgetFactory, times(1)).create(any(Float.class), any());
        verify(budgetRepositoryGateway, times(1)).save(any(BudgetRepositoryModel.class));

    }
}
