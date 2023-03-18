package com.aleksei.animalisland.utils.factories;



import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.animals.*;
import com.aleksei.animalisland.config.EntityConfig;
import com.aleksei.animalisland.models.plant.Plant;
import com.aleksei.animalisland.utils.enumartion.AnimalType;
import com.aleksei.animalisland.utils.exceptions.UnknownAnimalException;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.IntStream;


public class CellFactory {
    private final EntityConfig entityConfig = new EntityConfig();

    public Location createCell() {
        Location location = new Location();

        for (Class<? extends EntityAI> inhabitantClass : entityConfig.entityClassList) {

            EntityAI entityAI = AnimalFactory.getInstance().create(AnimalType.valueOf(inhabitantClass.getSimpleName().toUpperCase()));


            int maxNumberOnCell = 0;
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
                        sortAnimal(location, entityAI);
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

    private void sortAnimal(Location location, EntityAI entityAI) {
        if (entityAI.getClass().equals(Bear.class)) {
            location.getBears().add((Bear) entityAI);
        } else if (entityAI.getClass().equals(Boar.class)) {
            location.getBoars().add((Boar) entityAI);
        } else if (entityAI.getClass().equals(Rabbit.class)) {
            location.getRabbits().add((Rabbit) entityAI);
        } else if (entityAI.getClass().equals(Wolf.class)) {
            location.getWolves().add((Wolf) entityAI);
        } else {
            throw new UnknownAnimalException("Unknown animal");
        }

    }
}