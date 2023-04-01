package com.aleksei.animalisland.services;


import com.aleksei.animalisland.config.BaseConfig;
import com.aleksei.animalisland.config.EntityConfig;
import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.EntityAI;
import com.aleksei.animalisland.models.plant.Plant;
import com.aleksei.animalisland.utils.enumartion.AnimalType;
import com.aleksei.animalisland.utils.factories.AnimalFactory;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@RequiredArgsConstructor
public class IslandService<T extends EntityAI> {
    private final BaseConfig CONFIG = BaseConfig.getAppConfig();
    private final AnimalService animalService = new AnimalService();
    private final EntityConfig entityConfig = EntityConfig.getInstance();
    private final int ISLAND_WIDTH = CONFIG.getIslandWidth();
    private final int ISLAND_HEIGHT = CONFIG.getIslandHeight();
    private Location[][] island = new Location[ISLAND_WIDTH][ISLAND_HEIGHT];


    public void init() {
        Location location = new Location();
        for (int y = 0; y < ISLAND_HEIGHT; y++) {
            for (int x = 0; x < ISLAND_WIDTH; x++) {
                island[x][y] = new Location();
                addEntityToLocation(island[x][y]);
            }
        }
    }

    private void addEntityToLocation(Location location) {

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
    }

    private Object getLocation() {
        return IntStream.range(0, ISLAND_HEIGHT)
                .flatMap(x -> IntStream.range(0, ISLAND_WIDTH)
                        .filter(y -> island[x][y].getAnimals().isEmpty()))
                .collect(Collectors.toList());
    }

}
