package com.atwop.katanga.budget.infrastructure.datasource.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "budget")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDataMapper {
    @Id
    private String id;
    private String userId;
    private Float amount;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
    private LocalDateTime dateClosed;
}
