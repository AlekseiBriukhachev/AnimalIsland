package com.aleksei.animalisland.services;


import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.animal.Animal;
import com.aleksei.animalisland.models.animal.EntityAI;
import com.aleksei.animalisland.config.EntityConfig;
import com.aleksei.animalisland.models.plant.Plant;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class EatService {
    private Location location;
    private final EntityConfig entityConfig = new EntityConfig();

    public void animalEat(Location location) {
        this.location = location;
        for (int i = 0; i < location.getAnimals().size(); i++) {
            getAnimalEat(location.getAnimals().get(i));
        }
    }

    private void getAnimalEat(Animal hunter) {
        Map<Class<? extends EntityAI>, Integer> victimMap =
                entityConfig.eatingProbabilityMap.get(hunter.getClass());
        for (Map.Entry<Class<? extends EntityAI>, Integer> victimEntry : victimMap.entrySet()) {
            int randomProbability = ThreadLocalRandom.current().nextInt(100);
            if (victimEntry.getValue() != 0 && randomProbability >= victimEntry.getValue()
                    || victimEntry.getValue() == 100) {
                try {
                    removeAnimal(victimEntry.getKey().getConstructor().newInstance());
                } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                         InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void removeAnimal(EntityAI entityAI) {
        if (entityAI instanceof Animal) {
            for (Animal animal : location.getAnimals()) {
                if (animal.getClass().equals(entityAI.getClass())) {
                    location.getAnimals().remove(animal);
                    break;
                }
            }
        } else {
            for (Plant plant : location.getPlants()) {
                if (plant.getClass().equals(entityAI.getClass())) {
                    location.getPlants().remove(plant);
                    break;
                }
            }
        }
    }
}