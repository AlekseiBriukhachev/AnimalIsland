package com.aleksei.animalisland.utils.factories;


import com.aleksei.animalisland.config.EntityConfig;
import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.EntityAI;
import com.aleksei.animalisland.models.plant.Plant;
import com.aleksei.animalisland.utils.enumartion.AnimalType;

import java.util.Map;
import java.util.stream.IntStream;


public class CellFactory {
    private final EntityConfig entityConfig = EntityConfig.getInstance();

    public Location createCell() {
        Location location = new Location();

        for (Class<? extends EntityAI> inhabitantClass : entityConfig.entityClassList) {
            int maxNumberOnCell = 0;

            EntityAI entityAI = AnimalFactory.getInstance().create(AnimalType.valueOf(inhabitantClass.getSimpleName().toUpperCase()));
            for (Map.Entry<Class<? extends EntityAI>, Integer> maxNumberOnCellEntry : entityConfig.maxNumberOnCellMap.entrySet()) {
                if (inhabitantClass.equals(maxNumberOnCellEntry.getKey())) {
                    maxNumberOnCell = maxNumberOnCellEntry.getValue();
                    break;
                }
            }

            int number = (int) (Math.random() * maxNumberOnCell);
            IntStream.rangeClosed(0, number).forEachOrdered(i -> {
                try {
                    if (entityAI instanceof Animal) {
                        location.getAnimals().add((Animal) entityAI.clone());
                    } else {
                        location.getPlants().add((Plant) entityAI.clone());
                    }
                } catch (CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        return location;
    }
}