package com.zenika.vhr.maintenance.application.mapper;

import java.time.LocalDate;
import java.util.UUID;

import com.zenika.vhr.maintenance.application.dto.AjouterInterventionDto;
import com.zenika.vhr.maintenance.domaine.intervention.DateIntervention;
import com.zenika.vhr.maintenance.domaine.intervention.Intervention;
import com.zenika.vhr.maintenance.domaine.intervention.InterventionId;

public class InterventionMapper {

    public Intervention enIntervention(AjouterInterventionDto dto) {
        Intervention intervention = Intervention.create(new InterventionId(UUID.randomUUID().toString()),
            new DateIntervention(dto.date(), LocalDate.now()));

        intervention.setNom(dto.nom());

        return intervention;
    }

}
