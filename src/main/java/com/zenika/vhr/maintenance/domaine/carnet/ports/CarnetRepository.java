package com.zenika.vhr.maintenance.domaine.carnet.ports;

import com.zenika.vhr.maintenance.domaine.carnet.model.Carnet;

public interface CarnetRepository {

    Carnet obtenirCarnet(String id);

    void sauvegarder(Carnet carnet);

}
