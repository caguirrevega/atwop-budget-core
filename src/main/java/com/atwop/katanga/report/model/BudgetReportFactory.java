package com.atwop.katanga.report.model;

import java.util.Map;

public interface BudgetReportFactory {
    BudgetReport create(String budgetId, Float inputTotal, Float outputTotal);
}
