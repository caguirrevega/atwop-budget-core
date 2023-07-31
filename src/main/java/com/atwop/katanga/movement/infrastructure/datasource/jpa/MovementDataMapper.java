package com.atwop.katanga.movement.infrastructure.datasource.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "movement")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovementDataMapper {

    @Id
    private String id;

    private String description;

    private  Float amount;

    private String typeMovement;

    private LocalDateTime dateCreated;

    private LocalDateTime lastUpdated;

    private String budgetId;
}
