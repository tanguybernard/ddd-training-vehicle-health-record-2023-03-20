package com.zenika.vhr.maintenance.infrastructure.postgresql.intervention;

import com.zenika.vhr.maintenance.domaine.intervention.Intervention;

public class InterventionPgMapper {


    InterventionEntity fromDomain(Intervention intervention){
        InterventionEntity i =  new InterventionEntity();
        i.id = intervention.getId().id;
        i.name = intervention.getNom();
        return i;
    }
}
