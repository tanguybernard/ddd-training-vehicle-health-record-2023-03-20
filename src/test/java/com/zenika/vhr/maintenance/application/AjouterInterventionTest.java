package com.zenika.vhr.maintenance.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import com.zenika.vhr.maintenance.application.usecases.AjouterIntervention;
import com.zenika.vhr.maintenance.domaine.carnet.model.CarnetId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zenika.vhr.maintenance.application.dto.AjouterInterventionDto;
import com.zenika.vhr.maintenance.application.mapper.InterventionMapper;
import com.zenika.vhr.maintenance.domaine.carnet.model.Carnet;
import com.zenika.vhr.maintenance.domaine.carnet.ports.CarnetRepository;
import com.zenika.vhr.maintenance.domaine.intervention.InterventionRepository;
import com.zenika.vhr.maintenance.stubs.InMemoryCarnetRepository;
import com.zenika.vhr.maintenance.stubs.InMemoryInterventionRepository;


class AjouterInterventionTest {

    private static final String ID_CARNET = "idCarnet";

    private AjouterIntervention ajouterIntervention;

    private InterventionMapper interventionMapper;
    private InterventionRepository interventionRepository;
    private CarnetRepository carnetRepository;

    @BeforeEach
    void configuration() {
        interventionRepository = new InMemoryInterventionRepository();
        carnetRepository = new InMemoryCarnetRepository();
        interventionMapper = new InterventionMapper();
        ajouterIntervention = new AjouterIntervention(interventionMapper, interventionRepository, carnetRepository);
    }

    @Test
    void doit_ajouter_intervention() {

        // GIVEN
        // un carnet
        Carnet carnet = new Carnet(new CarnetId(ID_CARNET));
        carnetRepository.sauvegarder(carnet);

        var ajouterInterventionDto = new AjouterInterventionDto(LocalDate.of(2023, 3, 21), "Une intervention");

        // WHEN
        ajouterIntervention.ajouter(ID_CARNET, ajouterInterventionDto);


        // THEN
        assertThat(carnetRepository.obtenirCarnet(ID_CARNET)).isNotNull();
        assertThat(carnetRepository.obtenirCarnet(ID_CARNET).getInterventionIdList()).hasSize(1);


    }
}
