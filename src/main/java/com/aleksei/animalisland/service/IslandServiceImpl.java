package com.aleksei.animalisland.service;


import com.aleksei.animalisland.config.AppConfig;
import com.aleksei.animalisland.model.Animal;
import com.aleksei.animalisland.model.Location;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class IslandServiceImpl implements IslandService {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    private final int width = CONFIG.getIslandWidth();
    private final int height = CONFIG.getIslandHeight();
    private final Location[][] island = new Location[width][height];

    @Override
    public void initIsland() {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                Location location = new Location();
                island[x][y] = location;
                addEntity(location);

            }
        }
    }

    private void addEntity(Location location) {
        int numberOfEntity = ThreadLocalRandom.current().nextInt();


//        IntStream.rangeClosed(0, width * height).forEachOrdered(value -> );


//        IntStream.rangeClosed(0, number).forEachOrdered(i -> {
//            try {
//                if (entityAI instanceof Animal) {
//                    location.getAnimals().add((Animal) entityAI.clone());
//                } else {
//                    location.getPlants().add((Plant) entityAI.clone());
//                }
//            } catch (CloneNotSupportedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//        for (Class<? extends EntityAI> entityClass : entityConfig.entityClassList) {
//
//            int maxNumberOnCell;
//
//            try {
//
//                EntityAI entityAI = entityClass.getConstructor().newInstance();
//
//
//                maxNumberOnCell = entityConfig.maxNumberOnCellMap.entrySet().stream()
//                        .filter(maxNumberOnCellEntry -> entityClass.equals(maxNumberOnCellEntry.getKey()))
//                        .findFirst()
//                        .map(Map.Entry::getValue)
//                        .orElse(0);
//
//                int number = (int) (Math.random() * maxNumberOnCell);
    }
}
