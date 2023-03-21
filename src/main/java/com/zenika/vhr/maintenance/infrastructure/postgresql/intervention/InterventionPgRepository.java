package com.zenika.vhr.maintenance.infrastructure.postgresql.intervention;

import com.zenika.vhr.maintenance.domaine.intervention.Intervention;
import com.zenika.vhr.maintenance.domaine.intervention.InterventionRepository;

public class InterventionPgRepository implements InterventionRepository {


    private InterventionDAO interventionDAO;
    private InterventionPgMapper interventionMapper;

    public InterventionPgRepository(InterventionDAO interventionDAO, InterventionPgMapper interventionMapper) {

        this.interventionDAO = interventionDAO;
        this.interventionMapper = interventionMapper;
    }

    @Override
    public void sauvegarder(Intervention intervention) {
        this.interventionDAO.save(interventionMapper.fromDomain(intervention));
    }
}
