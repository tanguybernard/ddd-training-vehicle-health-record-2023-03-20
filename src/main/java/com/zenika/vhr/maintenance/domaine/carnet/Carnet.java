package com.zenika.vhr.maintenance.domaine.carnet;

import java.util.ArrayList;
import java.util.List;

import com.zenika.vhr.maintenance.domaine.intervention.Intervention;
import com.zenika.vhr.maintenance.domaine.intervention.InterventionId;

public class Carnet {

    private String id;
    private String VIN;
    private List<InterventionId> interventionIdList = new ArrayList<>();


    public void ajouterIntervention(Intervention intervention) {
        interventionIdList.add(intervention.getId());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public List<InterventionId> getInterventionIdList() {
        return interventionIdList;
    }

    public void setInterventionIdList(List<InterventionId> interventionIdList) {
        this.interventionIdList = interventionIdList;
    }
}
