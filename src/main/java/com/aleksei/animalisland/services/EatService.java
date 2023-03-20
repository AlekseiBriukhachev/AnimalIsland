package com.aleksei.animalisland.services;


import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.EntityAI;
import com.aleksei.animalisland.config.EntityConfig;
import com.aleksei.animalisland.models.plant.Plant;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
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
//                log.info("Animal is hunting");

                try {
                    removeAnimal(victimEntry.getKey().getConstructor().newInstance());
                } catch (InstantiationException e) {
                    log.error("InstantiationException");
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    log.error("IllegalAccessException");
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    log.error("InvocationTargetException");
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException e) {
                    log.error("NoSuchMethodException");
                    throw new RuntimeException(e);
                }

            }
        }
    }

    private void removeAnimal(EntityAI entityAI) {
        if (entityAI instanceof Animal) {
            for (Animal animal : location.getAnimals()) {
                if (animal.equals(entityAI)) {
                    location.getAnimals().remove(animal);
                    log.info(entityAI.getName() + " eat " + animal.getName());
                    break;
                }
            }
        } else {
            for (Plant plant : location.getPlants()) {
                if (plant.equals(entityAI)) {
                    location.getPlants().remove(plant);
                    log.info(entityAI.getName() + " eat " + plant.getName());
                    break;
                }
            }
        }
    }
}