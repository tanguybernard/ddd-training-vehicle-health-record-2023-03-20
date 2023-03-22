package com.zenika.vhr.inscription.application;

import com.zenika.vhr.inscription.infrastructure.events.AssocierVehiculeIntegrationEvent;
import com.zenika.vhr.shared_kernel.infrastructure.IntegrationEvent;

public class AssocierVoitureAuClient {


    private Object bus;

    AssocierVoitureAuClient(
        //repository
        Object bus
    ){

        this.bus = bus;
    }


    public void execute(){


        // Client = CientREpository.associer

        //this.bus.emit(new AssocierVehiculeIntegrationEvent());


    }


}
