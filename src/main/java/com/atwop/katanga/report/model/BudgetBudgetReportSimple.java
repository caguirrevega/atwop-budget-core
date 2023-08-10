package com.atwop.katanga.report.model;


public class BudgetBudgetReportSimple implements BudgetReport {

    private String budgetId;

    private Float inputTotal;

    private Float outputTotal;

    public BudgetBudgetReportSimple(String budgetId, Float inputTotal, Float outputTotal) {
        this.budgetId = budgetId;
        this.inputTotal = inputTotal;
        this.outputTotal = outputTotal;

    }

    @Override
    public String getBudgetId() {
        return budgetId;
    }

    @Override
    public Float getInputTotal() {
        return inputTotal;
    }

    @Override
    public Float getOutputTotal() {
        return outputTotal;
    }
}
