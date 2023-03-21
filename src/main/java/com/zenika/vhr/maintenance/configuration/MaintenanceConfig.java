package com.zenika.vhr.maintenance.configuration;

import com.zenika.vhr.maintenance.application.AjouterIntervention;
import com.zenika.vhr.maintenance.application.mapper.InterventionMapper;
import com.zenika.vhr.maintenance.domaine.carnet.CarnetRepository;
import com.zenika.vhr.maintenance.domaine.intervention.InterventionRepository;
import com.zenika.vhr.maintenance.infrastructure.postgresql.carnet.CarnetDao;
import com.zenika.vhr.maintenance.infrastructure.postgresql.carnet.CarnetPgRepository;
import com.zenika.vhr.maintenance.infrastructure.postgresql.intervention.InterventionDAO;
import com.zenika.vhr.maintenance.infrastructure.postgresql.intervention.InterventionPgMapper;
import com.zenika.vhr.maintenance.infrastructure.postgresql.intervention.InterventionPgRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MaintenanceConfig {


    @Bean
    InterventionRepository interventionRepository(InterventionDAO interventionDAO){
        return  new InterventionPgRepository(interventionDAO, new InterventionPgMapper());
    }

    @Bean
    CarnetRepository carnetRepository(CarnetDao dao){
        return  new CarnetPgRepository(dao);

    }

    @Bean
    public AjouterIntervention ajouterIntervention(InterventionRepository interventionRepository, CarnetRepository carnetRepository){

        var interventionMapper = new InterventionMapper();
        return new AjouterIntervention(interventionMapper, interventionRepository, carnetRepository);

    }

}
