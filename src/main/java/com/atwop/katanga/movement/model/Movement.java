package com.atwop.katanga.movement.model;

import java.time.LocalDateTime;

public interface Movement {

    String validate();

    String getId();

    String getDescription();

    Float getAmount();

    LocalDateTime getDateCreated();

    LocalDateTime getLastUpdated();

    String getTypeMovement();

    String getBudgetId();
}

