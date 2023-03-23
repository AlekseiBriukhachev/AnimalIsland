package com.aleksei.animalisland.services;


import com.aleksei.animalisland.models.Island.Location;

public class ControlService {
    private final EatService eatService = new EatService();
    private final GrassGrowService grassGrowService = new GrassGrowService();
    private final ReproductionService reproductionService = new ReproductionService();

    public void animalEat(Location location) {
        eatService.animalEat(location);
    }

    public void grassGrow(Location location) {
        grassGrowService.grassGrow(location);
    }

    public void animalReproduction(Location location) {
        reproductionService.animalReproduction(location);
    }
}
