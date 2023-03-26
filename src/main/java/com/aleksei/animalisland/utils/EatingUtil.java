package com.aleksei.animalisland.utils;

import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.EntityAI;
import com.aleksei.animalisland.services.AnimalService;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class EatingUtil {
    private static AnimalService animalService;

    public EatingUtil(AnimalService animalService) {
        EatingUtil.animalService = animalService;
    }

    public Animal getAnimalToEat() {
        return animalService.getLocation().getAnimals().stream()
                .filter(this::canEat)
                .findFirst()
                .orElse(null);
    }

    private boolean canEat(Animal hunter) {
        Map<Class<? extends EntityAI>, Integer> victimMap =
                animalService.getEntityConfig().eatingProbabilityMap.get(hunter.getClass());
        for (Map.Entry<Class<? extends EntityAI>, Integer> victimEntry : victimMap.entrySet()) {
            int randomProbability = ThreadLocalRandom.current().nextInt(100);

            if (victimEntry.getValue() != 0 && victimEntry.getValue() >= randomProbability) {

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
        return false;
    }

    private void removeEntity(EntityAI entityAI) {
        if (entityAI instanceof Animal) {
            animalService.getLocation().getAnimals().remove(entityAI);
        } else {
            animalService.getLocation().getPlants().remove(entityAI);
        }
    }
}