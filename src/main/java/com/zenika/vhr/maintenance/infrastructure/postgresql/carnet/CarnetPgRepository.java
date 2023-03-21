package com.zenika.vhr.maintenance.infrastructure.postgresql.carnet;

import com.zenika.vhr.maintenance.domaine.carnet.Carnet;
import com.zenika.vhr.maintenance.domaine.carnet.CarnetId;
import com.zenika.vhr.maintenance.domaine.carnet.CarnetRepository;
import com.zenika.vhr.maintenance.domaine.intervention.Intervention;
import com.zenika.vhr.maintenance.domaine.intervention.InterventionId;
import com.zenika.vhr.maintenance.domaine.intervention.InterventionRepository;
import com.zenika.vhr.maintenance.infrastructure.postgresql.intervention.InterventionEntity;
import com.zenika.vhr.maintenance.infrastructure.postgresql.intervention.InterventionPgMapper;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarnetPgRepository implements CarnetRepository {


    private CarnetDao carnetDao;

    public CarnetPgRepository(CarnetDao carnetDao) {

        this.carnetDao = carnetDao;
    }


    @Override
    public Carnet obtenirCarnet(String id) {
        var e = this.carnetDao.findById(id).orElseThrow();
        Carnet c = new Carnet(new CarnetId(e.id))   ;
        c.setInterventionIdList(e.interventions.stream().map(i -> new InterventionId(i.id)).collect(Collectors.toCollection(ArrayList::new)));
        return c;

    }

    @Override
    public void sauvegarder(Carnet carnet) {

        CarnetEntity c = new CarnetEntity();
        c.id = carnet.getId().id;
        c.interventions = carnet.getInterventionIdList().stream().map(interventionId -> {
            InterventionEntity i  = new InterventionEntity();
            i.id = interventionId.id;
            return i;
        }).collect(Collectors.toSet());

        this.carnetDao.save(c);
    }
}
