package com.zenika.vhr.maintenance.integration;

import com.zenika.vhr.maintenance.application.AjouterIntervention;
import com.zenika.vhr.maintenance.application.dto.AjouterInterventionDto;
import com.zenika.vhr.maintenance.application.mapper.InterventionMapper;
import com.zenika.vhr.maintenance.domaine.carnet.Carnet;
import com.zenika.vhr.maintenance.domaine.carnet.CarnetId;
import com.zenika.vhr.maintenance.domaine.carnet.CarnetRepository;
import com.zenika.vhr.maintenance.domaine.intervention.InterventionRepository;
import com.zenika.vhr.maintenance.infrastructure.postgresql.intervention.InterventionPgRepository;
import com.zenika.vhr.maintenance.stubs.InMemoryCarnetRepository;
import com.zenika.vhr.maintenance.stubs.InMemoryInterventionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AjouterInterventionTest {

    private static final String ID_CARNET = "idCarnet";

    @Autowired
    private AjouterIntervention ajouterIntervention;
    @Autowired
    private InterventionRepository interventionRepository;
    @Autowired
    private CarnetRepository carnetRepository;



    @Test
    @Transactional
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
