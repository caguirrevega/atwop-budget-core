package com.atwop.katanga.movement.usecase;

import com.atwop.katanga.budget.model.BudgetRepositoryGateway;
import com.atwop.katanga.movement.model.BudgetMovement;
import com.atwop.katanga.movement.model.Movement;
import com.atwop.katanga.movement.model.MovementFactory;
import com.atwop.katanga.movement.model.MovementInputBoundary;
import com.atwop.katanga.movement.model.MovementPresenter;
import com.atwop.katanga.movement.model.MovementRepositoryGateway;
import com.atwop.katanga.movement.model.MovementRepositoryRequestModel;
import com.atwop.katanga.movement.model.MovementRequestModel;
import com.atwop.katanga.movement.model.MovementResponseModel;

public class BudgetMovementCreationUseCase implements MovementInputBoundary {

    private final MovementPresenter movementPresenter;
    private final MovementFactory movementFactory;
    private final MovementRepositoryGateway movementRepositoryGateway;
    private final BudgetRepositoryGateway budgetRepositoryGateway;

    public BudgetMovementCreationUseCase(MovementPresenter movementPresenter, MovementFactory movementFactory,
                                         MovementRepositoryGateway movementRepositoryGateway,
                                         BudgetRepositoryGateway budgetRepositoryGateway) {
        this.movementPresenter = movementPresenter;
        this.movementFactory = movementFactory;
        this.movementRepositoryGateway = movementRepositoryGateway;
        this.budgetRepositoryGateway = budgetRepositoryGateway;
    }

    @Override
    public MovementResponseModel create(MovementRequestModel request) {
        Movement movement = movementFactory.create(request.getDescription(), request.getAmount()
                , request.getBudgetId(), request.getTypeMovement());
        String messageValidation = movement.validate();
        if (messageValidation != null) {
            movementPresenter.prepareBadRequestResponse(messageValidation);
        }
        if (budgetRepositoryGateway.findById(request.getBudgetId()).isEmpty()) {
            movementPresenter.prepareNotFoundResponse("budget not found");
        }
        MovementRepositoryRequestModel movementRepositoryRequestModel = new MovementRepositoryRequestModel(
                movement.getId(),
                movement.getDescription(),
                movement.getAmount(),
                movement.getDateCreated(),
                movement.getLastUpdated(),
                request.getTypeMovement(),
                request.getBudgetId());

        movementRepositoryGateway.save(movementRepositoryRequestModel);

        return movementPresenter.prepareSuccessfulResponse(movement.getId(), movement.getAmount());
    }
}
