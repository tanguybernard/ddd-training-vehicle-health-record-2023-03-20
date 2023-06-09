package com.zenika.vhr.shared_kernel;

import com.zenika.vhr.shared_kernel.domain_event.DomainEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class AggregateRoot<Id> extends Entity<Id> {


    public AggregateRoot(Id id) {
        super(id);
        this.id = id;
    }

    private List<DomainEvent> domainEvents = new ArrayList<>();

    public List<DomainEvent> pullDomainEvents() {
        List<DomainEvent> domainEvents = this.domainEvents;
        this.domainEvents = new ArrayList<>();
        return domainEvents;
    }

    protected void record(DomainEvent domainEvent) {
        this.domainEvents.add(domainEvent);
    }
}