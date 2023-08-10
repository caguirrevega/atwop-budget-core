package com.atwop.katanga.report.model;


public interface ReportPresenter {
    BudgetReport prepareBadRequestResponse(String error);

    BudgetReport prepareNotFoundResponse(String error);
}
