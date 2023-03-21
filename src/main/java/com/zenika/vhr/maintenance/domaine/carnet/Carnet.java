package com.zenika.vhr.maintenance.domaine.carnet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zenika.vhr.maintenance.application.events.InterventionSauvegardeEvent;
import com.zenika.vhr.maintenance.domaine.intervention.Intervention;
import com.zenika.vhr.maintenance.domaine.intervention.InterventionId;
import com.zenika.vhr.shared_kernel.AggregateRoot;

public class Carnet extends AggregateRoot<CarnetId> {

    private String VIN;
    private List<InterventionId> interventionIdList = new ArrayList<>();

    public Carnet(CarnetId carnetId) {
        super(carnetId);
    }


    public void ajouterIntervention(Intervention intervention) {
        interventionIdList.add(intervention.getId());
        this.record(new InterventionSauvegardeEvent(LocalDate.now(), "InterventionSauvegarde", intervention.getId()));
        //this.bus.dispatch(new InterventionSauvegardeEvent(LocalDate.now(), "InterventionSauvegarde", intervention.getId()));
    }

    public CarnetId getId() {
        return this.id;
    }

    public List<InterventionId> getInterventionIdList() {
        return interventionIdList;
    }

    public void setInterventionIdList(List<InterventionId> interventionIdList) {
        this.interventionIdList = interventionIdList;
    }
}
