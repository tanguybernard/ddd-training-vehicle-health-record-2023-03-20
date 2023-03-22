package com.zenika.vhr.maintenance.integration;

import com.zenika.vhr.maintenance.application.usecases.AjouterIntervention;
import com.zenika.vhr.maintenance.application.dto.AjouterInterventionDto;
import com.zenika.vhr.maintenance.domaine.carnet.model.Carnet;
import com.zenika.vhr.maintenance.domaine.carnet.model.CarnetId;
import com.zenika.vhr.maintenance.domaine.carnet.ports.CarnetRepository;
import com.zenika.vhr.maintenance.domaine.intervention.InterventionRepository;
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

        LocalDate date = LocalDate.now().plusDays(1);
        var ajouterInterventionDto = new AjouterInterventionDto(date, "Une intervention");

        // WHEN
        ajouterIntervention.ajouter(ID_CARNET, ajouterInterventionDto);


        // THEN
        assertThat(carnetRepository.obtenirCarnet(ID_CARNET)).isNotNull();
        assertThat(carnetRepository.obtenirCarnet(ID_CARNET).getInterventionIdList()).hasSize(1);


    }
}
