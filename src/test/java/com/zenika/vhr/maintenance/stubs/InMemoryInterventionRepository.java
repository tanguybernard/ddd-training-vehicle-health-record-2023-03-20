package com.zenika.vhr.maintenance.stubs;

import java.util.HashMap;
import java.util.Map;

import com.zenika.vhr.maintenance.domaine.intervention.Intervention;
import com.zenika.vhr.maintenance.domaine.intervention.InterventionId;
import com.zenika.vhr.maintenance.domaine.intervention.InterventionRepository;

public class InMemoryInterventionRepository implements InterventionRepository {

    private Map<InterventionId, Intervention> interventions = new HashMap<>();

    @Override
    public void sauvegarder(Intervention intervention) {
        interventions.put(intervention.getId(), intervention);
    }
}
