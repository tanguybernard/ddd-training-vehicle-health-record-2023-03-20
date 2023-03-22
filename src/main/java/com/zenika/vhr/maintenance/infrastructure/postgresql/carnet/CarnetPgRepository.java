package com.zenika.vhr.maintenance.infrastructure.postgresql.carnet;

import com.zenika.vhr.maintenance.domaine.carnet.model.Carnet;
import com.zenika.vhr.maintenance.domaine.carnet.model.CarnetId;
import com.zenika.vhr.maintenance.domaine.carnet.ports.CarnetRepository;
import com.zenika.vhr.maintenance.domaine.intervention.InterventionId;
import com.zenika.vhr.maintenance.infrastructure.postgresql.intervention.InterventionEntity;

import java.util.ArrayList;
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
