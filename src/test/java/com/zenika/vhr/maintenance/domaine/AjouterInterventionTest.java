package com.zenika.vhr.maintenance.domaine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

import java.time.LocalDate;

import com.zenika.vhr.maintenance.domaine.carnet.CarnetId;
import org.junit.jupiter.api.Test;

import com.zenika.vhr.maintenance.domaine.carnet.Carnet;
import com.zenika.vhr.maintenance.domaine.intervention.DateIntervention;
import com.zenika.vhr.maintenance.domaine.intervention.Intervention;
import com.zenika.vhr.maintenance.domaine.intervention.InterventionId;

class AjouterInterventionTest {

    @Test
    void doit_ajouter_intervention() {
        // GIVEN
        // un carnet
        var carnet = new Carnet(new CarnetId("idCarnet"));
        // une intervention

        var interventionId = new InterventionId("ID_INTER");
        var intervention = Intervention.create(interventionId,
            new DateIntervention(LocalDate.of(2023, 3, 21), LocalDate.of(2023, 3, 21)));

        // WHEN
        // l'ajout de l'intervention
        carnet.ajouterIntervention(intervention);

        // THEN
        // l'intervention est dans le carnet
        assertThat(carnet.getInterventionIdList()).hasSize(1);

    }

    @Test
    void doit_refuser_intervention_anterieure() {
        // GIVEN
        // une intervention
        LocalDate dateInter = LocalDate.of(2023, 3, 20);
        LocalDate dateJour = LocalDate.of(2023, 3, 21);

        // WHEN
        IllegalArgumentException illegalArgumentException = catchThrowableOfType(() -> new DateIntervention(dateInter, dateJour),
            IllegalArgumentException.class);

        // THEN
        assertThat(illegalArgumentException).isNotNull();

    }
}
