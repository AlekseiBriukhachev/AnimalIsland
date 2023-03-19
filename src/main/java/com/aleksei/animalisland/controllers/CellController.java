package com.aleksei.animalisland.controllers;


import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.services.EatService;
import com.aleksei.animalisland.services.GrassGrowService;
import com.aleksei.animalisland.services.ReproductionService;

public class CellController {
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
