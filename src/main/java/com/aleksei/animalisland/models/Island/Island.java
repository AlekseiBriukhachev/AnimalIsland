package com.aleksei.animalisland.models.Island;


import com.aleksei.animalisland.config.AppConfig;
import com.aleksei.animalisland.config.EntityConfig;
import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.EntityAI;
import com.aleksei.animalisland.models.plant.Grass;
import com.aleksei.animalisland.models.plant.Plant;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.stream.IntStream;

@Data
@Slf4j
public class Island {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    private final EntityConfig entityConfig = EntityConfig.getInstance();

    private final int width = CONFIG.getIslandWidth();
    private final int height = CONFIG.getIslandHeight();
    private final Location[][] island = new Location[width][height];

    public Island() {
    }

    public void init() {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                Location location = new Location();
                island[x][y] = location;
                addEntity(location);

            }
        }
    }

    private void addEntity(Location location) {

        for (Class<? extends EntityAI> entityClass : entityConfig.entityClassList) {

            int maxNumberOnCell;

            try {

                EntityAI entityAI = entityClass.getConstructor().newInstance();


            maxNumberOnCell = entityConfig.maxNumberOnCellMap.entrySet().stream()
                    .filter(maxNumberOnCellEntry -> entityClass.equals(maxNumberOnCellEntry.getKey()))
                    .findFirst()
                    .map(Map.Entry::getValue)
                    .orElse(0);

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
