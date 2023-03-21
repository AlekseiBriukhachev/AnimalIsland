package com.aleksei.animalisland.services;


import com.aleksei.animalisland.config.EntityConfig;
import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.EntityAI;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class EatService {
    private Location location;
    private final EntityConfig entityConfig = EntityConfig.getInstance();

    public void animalEat(Location location) {
        this.location = location;
        for (int i = 0; i < location.getAnimals().size(); i++) {
            animalHunt(location.getAnimals().get(i));
        }
    }

    private void animalHunt(Animal hunter) {
        Map<Class<? extends EntityAI>, Integer> victimMap =
                entityConfig.eatingProbabilityMap.get(hunter.getClass());
        for (Map.Entry<Class<? extends EntityAI>, Integer> victimEntry : victimMap.entrySet()) {
            int randomProbability = ThreadLocalRandom.current().nextInt(100);

            if (victimEntry.getValue() != 0 && victimEntry.getValue() >= randomProbability){

                try {
                    EntityAI entityAI = victimEntry.getKey().getConstructor().newInstance();
                    log.info(hunter.getName() + " eat " + entityAI.getName() + " with probability " + randomProbability + ". " + hunter.getName() + " power is " + victimEntry.getValue());

                    removeEntity(entityAI);

                } catch (InstantiationException e) {
                    log.error("TEST - InstantiationException");
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    log.error("TEST - IllegalAccessException");
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    log.error("TEST - InvocationTargetException");
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException e) {
                    log.error("TEST - NoSuchMethodException");
                    throw new RuntimeException(e);
                }

            }
        }
    }

    private void removeEntity(EntityAI entityAI) {
        if (entityAI instanceof Animal) {
                    location.getAnimals().remove(entityAI);
        } else {
                    location.getPlants().remove(entityAI);
        }
    }
}