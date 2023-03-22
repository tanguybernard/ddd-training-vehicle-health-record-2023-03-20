package com.zenika.vhr.maintenance.application.usecases;

import com.zenika.vhr.maintenance.application.dto.AjouterInterventionDto;
import com.zenika.vhr.maintenance.application.mapper.InterventionMapper;
import com.zenika.vhr.maintenance.domaine.carnet.model.Carnet;
import com.zenika.vhr.maintenance.domaine.carnet.ports.CarnetRepository;
import com.zenika.vhr.maintenance.domaine.intervention.Intervention;
import com.zenika.vhr.maintenance.domaine.intervention.InterventionRepository;
import com.zenika.vhr.shared_kernel.domain_event.DomainEventPublisher;

public class AjouterIntervention {

    private final InterventionMapper interventionMapper;
    private final InterventionRepository interventionRepository;
    private final CarnetRepository carnetRepository;

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
        carnet.pullDomainEvents().forEach(DomainEventPublisher::dispatch);

    }

}
