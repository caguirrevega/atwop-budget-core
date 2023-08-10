package com.atwop.katanga.budget.infrastructure.datasource.jpa;

import com.atwop.katanga.budget.model.BudgetRepositoryGateway;
import com.atwop.katanga.budget.model.BudgetRepositoryModel;
import com.atwop.katanga.movement.infrastructure.datasource.jpa.MovementDataMapper;
import com.atwop.katanga.movement.model.MovementRepositoryRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JpaBudgetRepositoryService implements BudgetRepositoryGateway {
    private final JpaBudgetRepository jpaBudgetRepository;
    @Override
    public void save(BudgetRepositoryModel requestModel) {
        List<MovementDataMapper> movementDataMappers = Optional.ofNullable(requestModel.getMovements())
                .orElse(Collections.emptyList()).stream()
                .map(e -> MovementDataMapper.builder()
                        .id(e.getId())
                        .description(e.getDescription())
                        .typeMovement(e.getTypeMovement())
                        .budgetId(e.getBudgetId())
                        .dateCreated(e.getDateCreated())
                        .amount(e.getAmount())
                        .lastUpdated(e.getLastUpdated())
                        .build())
                .collect(Collectors.toList());
        BudgetDataMapper budgetDataMapper = BudgetDataMapper
                .builder()
                .id(requestModel.getId())
                .amount(requestModel.getAmount())
                .dateCreated(requestModel.getDateCreated())
                .lastUpdated(requestModel.getLastUpdated())
                .dateClosed(requestModel.getDateClosed())
                .userId(requestModel.getUserId())
                .movements(movementDataMappers)
                .build();
        jpaBudgetRepository.save(budgetDataMapper);
    }

    @Override
    public Optional<BudgetRepositoryModel> findById(String id) {
        Optional<BudgetDataMapper> budgetDataMapper = jpaBudgetRepository.findById(id);

        if (budgetDataMapper.isPresent()) {
            List<MovementRepositoryRequestModel> movemements = Optional.of(budgetDataMapper.get().getMovements()).orElse(Collections.emptyList())
                    .stream().map(e -> new MovementRepositoryRequestModel(e.getId(),
                    e.getDescription(),e.getAmount(), e.getDateCreated(), e.getLastUpdated(),
                    e.getTypeMovement(), e.getBudgetId()
                    )).collect(Collectors.toList());

            return Optional.of(new BudgetRepositoryModel(budgetDataMapper.get().getId(),
                    budgetDataMapper.get().getUserId(), budgetDataMapper.get().getAmount(),
                    budgetDataMapper.get().getDateCreated(), budgetDataMapper.get().getLastUpdated(),
                    budgetDataMapper.get().getDateClosed(), movemements));
        }

        return Optional.empty();
    }
}
