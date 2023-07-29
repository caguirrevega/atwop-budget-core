package com.atwop.katanga.budget.infrastructure.datasource.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBudgetRepository extends JpaRepository<BudgetDataMapper, String> {
}
