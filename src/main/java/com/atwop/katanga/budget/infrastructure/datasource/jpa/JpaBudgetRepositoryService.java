package com.atwop.katanga.budget.infrastructure.datasource.jpa;

import com.atwop.katanga.budget.model.BudgetRepositoryGateway;
import com.atwop.katanga.budget.model.BudgetRepositoryRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaBudgetRepositoryService implements BudgetRepositoryGateway {
    private final JpaBudgetRepository jpaBudgetRepository;
    @Override
    public void save(BudgetRepositoryRequestModel requestModel) {
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
}
