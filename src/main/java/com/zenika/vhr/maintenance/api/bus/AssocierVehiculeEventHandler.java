package com.zenika.vhr.maintenance.api.bus;

import com.zenika.vhr.maintenance.application.usecases.PlanifierIntervention;
import com.zenika.vhr.shared_kernel.infrastructure.IntegrationEvent;
import com.zenika.vhr.shared_kernel.infrastructure.IntegrationEventHandler;

public class AssocierVehiculeEventHandler implements IntegrationEventHandler {



    @Override
    public void handle(IntegrationEvent evt) {

        new PlanifierIntervention().execute();

    }
}
