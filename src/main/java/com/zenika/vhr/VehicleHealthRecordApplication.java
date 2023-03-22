package com.zenika.vhr;

import com.zenika.vhr.maintenance.application.handler.HandleInterventionSauvegarde;
import com.zenika.vhr.maintenance.domaine.carnet.events.InterventionSauvegardeEvent;
import com.zenika.vhr.shared_kernel.domain_event.DomainEventPublisher;
import com.zenika.vhr.shared_kernel.domain_event.EventHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class VehicleHealthRecordApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(VehicleHealthRecordApplication.class, args);

        //DomainEventPublisher.register(new HandleInterventionSauvegarde(), InterventionSauvegardeEvent.class.getName());

    }





}
