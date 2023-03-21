package com.zenika.vhr.maintenance.infrastructure.postgresql.intervention;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InterventionDAO extends JpaRepository<InterventionEntity, String> {
}
