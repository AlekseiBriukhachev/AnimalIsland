package com.aleksei.animalisland.services;


import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.EntityAI;
import com.aleksei.animalisland.config.EntityConfig;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class ReproductionService {
    private final EntityConfig entityConfig = EntityConfig.getInstance();

    public void animalReproduction(Location location) {
        for (Class<? extends EntityAI> animalClass : entityConfig.entityClassList) {
            for (int i = 0; i < location.getAnimals().size(); i++) {
                boolean isReproduction = ThreadLocalRandom.current().nextBoolean();
                if (animalClass.equals(location.getAnimals().get(i).getClass()) && isReproduction) {
                    try {
                        Animal newAnimal = (Animal) animalClass.getConstructor().newInstance();
                        location.getAnimals().add(newAnimal);
                        log.info(newAnimal + " is created");
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
    }
}
