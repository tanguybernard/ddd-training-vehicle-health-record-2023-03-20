package com.zenika.vhr.maintenance.e2e;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zenika.vhr.maintenance.application.dto.AjouterInterventionDto;
import com.zenika.vhr.maintenance.configuration.MaintenanceConfig;
import com.zenika.vhr.maintenance.domaine.carnet.model.Carnet;
import com.zenika.vhr.maintenance.domaine.carnet.model.CarnetId;
import com.zenika.vhr.maintenance.domaine.carnet.ports.CarnetRepository;
import com.zenika.vhr.maintenance.domaine.intervention.InterventionId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AjouterInterventionE2ETest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    CarnetRepository carnetRepository;

    @Test
    @Transactional
    public void ajouterIntervention() throws Exception {
        //GIVEN
        this.carnetRepository.sauvegarder(new Carnet(new CarnetId("123")));

        AjouterInterventionDto dto = new AjouterInterventionDto(LocalDate.now(), "Changement pneumatique");
        byte[] contentAsBytes = objectMapper.writeValueAsBytes(dto);

        //WHEN
        MockHttpServletResponse reponse = mockMvc
                .perform(post("/api/carnets/123/interventions")
                        .content(contentAsBytes)
                        .contentType(MediaType.APPLICATION_JSON)

                ).andReturn().getResponse();


        //THEN
        assertThat(reponse.getStatus()).isEqualTo(201);
        String location = reponse.getHeader("Location");// /api/carnets/123/interventions/:idIntervention
        assertThat(reponse.getHeader("Location")).isNotNull();

        Carnet c = this.carnetRepository.obtenirCarnet("123");

        assertThat(c.getId().equals(new CarnetId("123"))).isTrue();

        var t = location.split("/");
        String id = t[t.length-1];

        assertThat(c.getInterventionIdList().get(0).id).isEqualTo(id);

    }

}
