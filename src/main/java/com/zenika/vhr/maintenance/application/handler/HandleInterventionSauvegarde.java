package com.zenika.vhr.maintenance.application.handler;

import com.zenika.vhr.maintenance.application.usecases.GenererJustificatif;
import com.zenika.vhr.maintenance.domaine.carnet.events.InterventionSauvegardeEvent;
import com.zenika.vhr.shared_kernel.domain_event.EventHandler;

public class HandleInterventionSauvegarde implements EventHandler<InterventionSauvegardeEvent> {


    @Override
    public void handle(InterventionSauvegardeEvent evt) {

        new GenererJustificatif().execute();

    }
}
