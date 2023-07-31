package com.atwop.katanga.movement.infrastructure.datasource.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMovementRepository extends JpaRepository<MovementDataMapper, String> {
}
