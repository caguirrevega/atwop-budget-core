package com.atwop.katanga.budget.infrastructure.datasource.jpa;

import com.atwop.katanga.budget.model.Budget;
import com.atwop.katanga.budget.model.BudgetRepositoryGateway;
import com.atwop.katanga.budget.model.BudgetRepositoryModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaBudgetRepositoryService implements BudgetRepositoryGateway {
    private final JpaBudgetRepository jpaBudgetRepository;
    @Override
    public void save(BudgetRepositoryModel requestModel) {
        BudgetDataMapper budgetDataMapper = BudgetDataMapper
                .builder()
                .id(requestModel.getId())
                .amount(requestModel.getAmount())
                .dateCreated(requestModel.getDateCreated())
                .lastUpdated(requestModel.getLastUpdated())
                .dateClosed(requestModel.getDateClosed())
                .userId(requestModel.getUserId())
                .build();
        jpaBudgetRepository.save(budgetDataMapper);
    }

    @Override
    public Optional<BudgetRepositoryModel> findById(String id) {
        Optional<BudgetDataMapper> budgetDataMapper = jpaBudgetRepository.findById(id);

        if (budgetDataMapper.isPresent()) {
            return Optional.of(new BudgetRepositoryModel(budgetDataMapper.get().getId(),
                    budgetDataMapper.get().getUserId(), budgetDataMapper.get().getAmount(),
                    budgetDataMapper.get().getDateCreated(), budgetDataMapper.get().getLastUpdated(),
                    budgetDataMapper.get().getDateClosed()));
        }

        return Optional.empty();
    }
}
