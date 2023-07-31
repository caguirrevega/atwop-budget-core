package com.atwop.katanga.budget.model;

import java.util.Optional;

public interface BudgetRepositoryGateway {

    void save (BudgetRepositoryModel requestModel);

    Optional<BudgetRepositoryModel> findById(String id);
}
