package com.aleksei.animalisland.utils.factories;



import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.EntityAI;
import com.aleksei.animalisland.config.EntityConfig;
import com.aleksei.animalisland.models.plant.Plant;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;


public class CellFactory {
    private final EntityConfig entityConfig = new EntityConfig();

    public Location createCell() {
        Location location = new Location();
        int number;
        int maxNumberOnCell = 0;
        for (Class<? extends EntityAI> inhabitantClass : entityConfig.entityClassList) {
            EntityAI entityAI;
            try {
                entityAI = inhabitantClass.getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            for (Map.Entry<Class<? extends EntityAI>, Integer> maxNumberOnCellEntry : entityConfig.maxNumberOnCellMap.entrySet()) {
                if (inhabitantClass.equals(maxNumberOnCellEntry.getKey())) {
                    maxNumberOnCell = maxNumberOnCellEntry.getValue();
                    break;
                }
            }
            number = (int) (Math.random() * maxNumberOnCell);
            for (int i = 0; i <= number; i++) {
                try {
                    if (entityAI instanceof Animal) {
                        location.getAnimals().add((Animal) entityAI.clone());
                    } else {
                        location.getPlants().add((Plant) entityAI.clone());
                    }
                } catch (CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return location;
    }
}