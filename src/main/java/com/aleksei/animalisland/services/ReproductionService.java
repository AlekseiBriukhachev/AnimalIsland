package com.aleksei.animalisland.services;


import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.animal.Animal;
import com.aleksei.animalisland.models.animal.EntityAI;
import com.aleksei.animalisland.config.EntityConfig;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;

public class ReproductionService {
    private final EntityConfig entityConfig = new EntityConfig();

    public void animalReproduction(Location location) {
        for (Class<? extends EntityAI> animalClass : entityConfig.entityClassList) {
            for (int i = 0; i < location.getAnimals().size(); i++) {
                boolean isReproduction = ThreadLocalRandom.current().nextBoolean();
                if (animalClass.equals(location.getAnimals().get(i).getClass()) && isReproduction) {
                    try {
                        location.getAnimals().add((Animal) animalClass.getConstructor().newInstance());
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                             NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
