package com.zenika.vhr.maintenance.infrastructure.postgresql.carnet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarnetDao extends JpaRepository<CarnetEntity, String> {
}
