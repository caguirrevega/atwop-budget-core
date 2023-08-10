package com.atwop.katanga.report.infrastructure.rest;

import com.atwop.katanga.report.model.BudgetReport;
import com.atwop.katanga.report.model.ReportInputBoundary;
import com.atwop.katanga.report.model.ReportRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BudgetReportController {

    private final ReportInputBoundary reportInputBoundary;

    @GetMapping("/report")
    BudgetReport generate(@RequestParam String budgetId) {
        return reportInputBoundary.generate(new ReportRequestModel(budgetId));
    }
}
