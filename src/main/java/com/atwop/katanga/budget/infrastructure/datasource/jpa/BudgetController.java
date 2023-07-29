package com.atwop.katanga.budget.infrastructure.datasource.jpa;

import com.atwop.katanga.budget.model.BudgetInputBoundary;
import com.atwop.katanga.budget.model.BudgetRequestModel;
import com.atwop.katanga.budget.model.BudgetResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BudgetController {
    final BudgetInputBoundary budgetInputBoundary;

    @PostMapping("/budget")
    BudgetResponseModel create(@RequestBody BudgetRequestModel budgetRequestModel) {
        return budgetInputBoundary.create(budgetRequestModel);
    }
}
