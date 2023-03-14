package com.aleksei.animalisland.services;


import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.config.EntityConfig;
import com.aleksei.animalisland.models.plant.Grass;

import java.util.concurrent.ThreadLocalRandom;

public class GrassGrowService {
    private final EntityConfig entityConfig = new EntityConfig();

    public void grassGrow(Location location) {
        Grass grass = new Grass();
        int grassMaxNumber = entityConfig.maxNumberOnCellMap.get(grass.getClass());
        int randomNumber = ThreadLocalRandom.current().nextInt(grassMaxNumber);
        for (int i = 0; i < randomNumber; i++) {
            location.getPlants().add(new Grass());
        }
    }
}
