package com.zenika.vhr.maintenance.infrastructure.postgresql.intervention;


import com.zenika.vhr.maintenance.domaine.carnet.Carnet;
import com.zenika.vhr.maintenance.infrastructure.postgresql.carnet.CarnetEntity;

import javax.persistence.*;

@Entity
public class InterventionEntity {
    @Id
    public String id;

    @Column
    public String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarnetEntity getCarnet() {
        return carnet;
    }

    public void setCarnet(CarnetEntity carnet) {
        this.carnet = carnet;
    }

    @ManyToOne
    @JoinColumn(name="carnet_id")
    public CarnetEntity carnet;



}
