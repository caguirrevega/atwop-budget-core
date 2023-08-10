package com.atwop.katanga.report.usecase;

import com.atwop.katanga.budget.model.BudgetRepositoryGateway;
import com.atwop.katanga.budget.model.BudgetRepositoryModel;
import com.atwop.katanga.report.model.BudgetReport;
import com.atwop.katanga.report.model.BudgetReportFactory;
import com.atwop.katanga.report.model.ReportInputBoundary;
import com.atwop.katanga.report.model.ReportPresenter;
import com.atwop.katanga.report.model.ReportRequestModel;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public class BudgetReportGenerateUseCase implements ReportInputBoundary {

    private final ReportPresenter reportPresenter;
    private final BudgetRepositoryGateway budgetRepositoryGateway;
    private final BudgetReportFactory budgetReportFactory;

    public BudgetReportGenerateUseCase(ReportPresenter reportPresenter, BudgetRepositoryGateway budgetRepositoryGateway, BudgetReportFactory budgetReportFactory) {
        this.reportPresenter = reportPresenter;
        this.budgetRepositoryGateway = budgetRepositoryGateway;
        this.budgetReportFactory = budgetReportFactory;
    }

    @Override
    public BudgetReport generate(ReportRequestModel reportRequestModel) {
        Optional<String> messageValidationOpt = reportRequestModel.validate();
        if (messageValidationOpt.isPresent()) {
            return reportPresenter.prepareBadRequestResponse(messageValidationOpt.get());
        }

        Optional<BudgetRepositoryModel> budgetOptional = budgetRepositoryGateway.findById(reportRequestModel.getBudgetId());
        if (budgetOptional.isEmpty()) {
            return reportPresenter.prepareNotFoundResponse(String.format("not found budgetId: %s", reportRequestModel.getBudgetId()));
        }

        Optional<Float> movementTotal = Optional.ofNullable(budgetOptional.get().getMovements())
                .orElse(Collections.emptyList())
                .stream().map(e -> e.getAmount())
                .collect(Collectors.toList()).stream().reduce(Float::sum);



        return budgetReportFactory.create(budgetOptional.get().getId(), budgetOptional.get().getAmount(),
                movementTotal.orElse(0F)) ;
    }
}
