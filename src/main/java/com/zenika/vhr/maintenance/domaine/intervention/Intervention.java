package com.zenika.vhr.maintenance.domaine.intervention;

import static java.util.Objects.requireNonNull;

import com.zenika.vhr.shared_kernel.AggregateRoot;

public class Intervention extends AggregateRoot<InterventionId> {

    private String nom;
    private DateIntervention dateIntervention;

    public Intervention(InterventionId interventionId) {
        super(interventionId);
    }

    public static Intervention create(InterventionId id, DateIntervention dateIntervention) {

        Intervention intervention = new Intervention(requireNonNull(id));
        intervention.setDateIntervention(requireNonNull(dateIntervention));
        return intervention;
    }

    public InterventionId getId() {
        return id;
    }

    public void setId(InterventionId id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public DateIntervention getDateIntervention() {
        return dateIntervention;
    }

    public void setDateIntervention(DateIntervention dateIntervention) {
        this.dateIntervention = dateIntervention;
    }
}
