package com.zenika.vhr.maintenance.stubs;

import java.util.HashMap;
import java.util.Map;

import com.zenika.vhr.maintenance.domaine.carnet.model.Carnet;
import com.zenika.vhr.maintenance.domaine.carnet.ports.CarnetRepository;

public class InMemoryCarnetRepository implements CarnetRepository {


    private final Map<String, Carnet> carnets = new HashMap<>();

    @Override
    public Carnet obtenirCarnet(String id) {
        return carnets.get(id);
    }

    @Override
    public void sauvegarder(Carnet carnet) {
        carnets.put(carnet.getId().id, carnet);
    }
}
