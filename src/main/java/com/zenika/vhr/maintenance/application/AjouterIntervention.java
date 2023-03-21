package com.zenika.vhr.maintenance.application;

import com.zenika.vhr.maintenance.application.dto.AjouterInterventionDto;
import com.zenika.vhr.maintenance.application.mapper.InterventionMapper;
import com.zenika.vhr.maintenance.domaine.carnet.Carnet;
import com.zenika.vhr.maintenance.domaine.carnet.CarnetRepository;
import com.zenika.vhr.maintenance.domaine.intervention.Intervention;
import com.zenika.vhr.maintenance.domaine.intervention.InterventionRepository;

public class AjouterIntervention {

    private final InterventionMapper interventionMapper;
    private final InterventionRepository interventionRepository;
    private final CarnetRepository carnetRepository;

    private Object queue;

    public AjouterIntervention(InterventionMapper interventionMapper, InterventionRepository interventionRepository,
        CarnetRepository carnetRepository) {
        this.interventionMapper = interventionMapper;
        this.interventionRepository = interventionRepository;
        this.carnetRepository = carnetRepository;
    }

    public void ajouter(String idCarnet, AjouterInterventionDto ajouterInterventionDto) {

        Carnet carnet = carnetRepository.obtenirCarnet(idCarnet);

        Intervention intervention = interventionMapper.enIntervention(ajouterInterventionDto);

        carnet.ajouterIntervention(intervention);

        interventionRepository.sauvegarder(intervention);
        carnetRepository.sauvegarder(carnet);

        //sync
        //new GenererJustificatif().execute();


        //async
        carnet.pullDomainEvents().forEach(event -> {
            //queue.dispatch(event)  //.callback(function -> success / Failed ?)
        });

    }

}
