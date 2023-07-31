package com.atwop.katanga.budget.model;

import java.time.LocalDateTime;

public interface Budget {
    String validate();

    String getId();

    Float getAmount();

    String getUserId();

    LocalDateTime getDateCreated();

    LocalDateTime getLastUpdated();

    LocalDateTime getDateClosed();


}
