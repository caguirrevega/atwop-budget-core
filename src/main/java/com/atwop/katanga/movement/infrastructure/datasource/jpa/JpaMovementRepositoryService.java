package com.atwop.katanga.movement.infrastructure.datasource.jpa;

import com.atwop.katanga.movement.model.MovementRepositoryGateway;
import com.atwop.katanga.movement.model.MovementRepositoryRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaMovementRepositoryService implements MovementRepositoryGateway {

    private final JpaMovementRepository jpaMovementRepository;

    @Override
    public void save(MovementRepositoryRequestModel request) {
        MovementDataMapper movementDataMapper = MovementDataMapper
                .builder()
                .id(request.getId())
                .description(request.getDescription())
                .amount(request.getAmount())
                .typeMovement(request.getTypeMovement())
                .dateCreated(request.getDateCreated())
                .lastUpdated(request.getLastUpdated())
                .budgetId(request.getBudgetId())
                .build();

        jpaMovementRepository.save(movementDataMapper);
    }
}
