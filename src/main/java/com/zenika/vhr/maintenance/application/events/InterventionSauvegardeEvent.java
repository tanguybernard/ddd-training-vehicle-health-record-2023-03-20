package com.zenika.vhr.maintenance.application.events;

import com.zenika.vhr.maintenance.domaine.intervention.InterventionId;
import com.zenika.vhr.shared_kernel.domain_event.DomainEvent;

import java.time.LocalDate;
import java.util.Date;

public class InterventionSauvegardeEvent implements DomainEvent {

    private String eventName;
    private LocalDate occuredOn;
    private InterventionId id;

    public InterventionSauvegardeEvent(LocalDate occuredOn, String eventName, InterventionId id){
        this.eventName = eventName;
        this.occuredOn = occuredOn;
        this.id = id;
    }





}
