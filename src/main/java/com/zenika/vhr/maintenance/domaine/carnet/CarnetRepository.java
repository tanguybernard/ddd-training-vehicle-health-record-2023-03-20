package com.zenika.vhr.maintenance.domaine.carnet;

public interface CarnetRepository {

    Carnet obtenirCarnet(String id);

    void sauvegarder(Carnet carnet);

}
