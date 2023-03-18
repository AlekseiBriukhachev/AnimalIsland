package com.aleksei.animalisland.controllers;


import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.repository.RabbitInfo;
import com.aleksei.animalisland.repository.WolfInfo;
import com.aleksei.animalisland.services.EatService;
import com.aleksei.animalisland.services.GrassGrowService;
import com.aleksei.animalisland.services.ReproductionService;
import com.aleksei.animalisland.services.animals.RabbitService;
import com.aleksei.animalisland.services.animals.WolfService;

public class CellController {
    private final EatService eatService = new EatService();
    private final RabbitService rabbitService = new RabbitService();
    private final GrassGrowService grassGrowService = new GrassGrowService();
    private final ReproductionService reproductionService = new ReproductionService();
    private final WolfService wolfService = new WolfService();

    public void animalEat(Location location) {
        wolfService.feed(location, (WolfInfo) this);
        rabbitService.feed(location, (RabbitInfo) this);
//        eatService.animalEat(location);

    }

    public void grassGrow(Location location) {
        grassGrowService.grassGrow(location);
    }

    public void animalReproduction(Location location) {
        reproductionService.animalReproduction(location);
    }
}
