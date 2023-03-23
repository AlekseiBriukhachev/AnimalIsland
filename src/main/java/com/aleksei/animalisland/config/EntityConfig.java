package com.aleksei.animalisland.config;


import com.aleksei.animalisland.models.animals.*;
import com.aleksei.animalisland.models.plant.Grass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EntityConfig {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();

    public final List<Class<? extends EntityAI>> entityClassList = List.of(Wolf.class, Snake.class, Fox.class,
            Bear.class, Eagle.class, Horse.class, Deer.class, Rabbit.class, Mouse.class, Goat.class, Sheep.class,
            Boar.class, Buffalo.class, Duck.class, Caterpillar.class, Grass.class);

    public final Map<Class<? extends EntityAI>, Map<Class<? extends EntityAI>, Integer>> eatingProbabilityMap =
            new HashMap<>();

    public final Map<Class<? extends EntityAI>, Integer> maxNumberOnCellMap =
            new HashMap<>();

    {
        fillEatingProbability();
        fillMaxNumberOnCellMap();
    }
    private static EntityConfig instance;
    private EntityConfig(){}
    public static synchronized EntityConfig getInstance(){
        if (instance == null){
            instance = new EntityConfig();
        }
        return instance;
    }

    private void fillEatingProbability() {
        for (var entityClass : entityClassList) {
            eatingProbabilityMap.put(entityClass, getEatingProbability(entityClass));
        }
    }

    private void fillMaxNumberOnCellMap() {
        for (var entityClass : entityClassList) {
            Integer maxNumberOnCell = CONFIG.getMaxNumberPerLocation(entityClass.getSimpleName().toLowerCase());

            maxNumberOnCellMap.put(entityClass, maxNumberOnCell);
        }
    }

    public Map<Class<? extends EntityAI>, Integer> getEatingProbability(Class<? extends EntityAI> hunterClass) {

        int[] eatingProbability = CONFIG.getEatingProbability(hunterClass);

        return IntStream.range(0, entityClassList.size())
                .boxed()
                .collect(Collectors.toMap(entityClassList::get, i -> eatingProbability[i], (a, b) -> b));
    }
}
