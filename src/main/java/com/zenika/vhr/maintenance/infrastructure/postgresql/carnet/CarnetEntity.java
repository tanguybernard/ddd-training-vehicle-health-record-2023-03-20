package com.zenika.vhr.maintenance.infrastructure.postgresql.carnet;


import com.zenika.vhr.maintenance.infrastructure.postgresql.intervention.InterventionEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class CarnetEntity {
    @Id
    public String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<InterventionEntity> getInterventions() {
        return interventions;
    }

    public void setInterventions(Set<InterventionEntity> interventions) {
        this.interventions = interventions;
    }

    @OneToMany(mappedBy="carnet")
    public Set<InterventionEntity> interventions;

}
