package com.atwop.katanga.report.model;

import java.util.Map;

public interface ReportInputBoundary {
    BudgetReport generate(ReportRequestModel reportRequestModel);
}
