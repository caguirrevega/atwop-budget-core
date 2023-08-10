package com.atwop.katanga.report.model;

public class BudgetReportSimpleFactory implements BudgetReportFactory{
    @Override
    public BudgetReport create(String budgetId, Float inputTotal, Float outputTotal) {
        return new BudgetBudgetReportSimple(budgetId, inputTotal, outputTotal);
    }
}
