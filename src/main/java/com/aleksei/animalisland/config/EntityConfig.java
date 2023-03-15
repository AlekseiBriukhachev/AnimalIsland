package com.aleksei.animalisland.config;


import com.aleksei.animalisland.models.animals.*;
import com.aleksei.animalisland.models.plant.Grass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class EntityConfig {
    private static final String FOLDER = "inhabitantprops";
    private static final String numberOnCell = "numberOnCell";

    public final List<Class<? extends EntityAI>> entityClassList = List.of(Boar.class,
            Buffalo.class, Caterpillar.class
            , Deer.class, Duck.class, Goat.class, Horse.class, Mouse.class, Rabbit.class
            , Sheep.class, Bear.class, Eagle.class, Fox.class, Snake.class, Wolf.class, Grass.class);

    public final Map<Class<? extends EntityAI>, Map<Class<? extends EntityAI>, Integer>> eatingProbabilityMap =
            new HashMap<>();

    public final Map<Class<? extends EntityAI>, Integer> maxNumberOnCellMap =
            new HashMap<>();

    {
        fillEatingProbability();
        fillMaxNumberOnCellMap();
    }

    private void fillEatingProbability() {
        for (Class<? extends EntityAI> entityClass : entityClassList) {
            eatingProbabilityMap.put(entityClass, getEatingProbability(entityClass));
        }
    }

    private void fillMaxNumberOnCellMap() {
        BaseProperties reader = new BaseProperties(FOLDER);
        for (Class<? extends EntityAI> entityClass : entityClassList) {
            Properties maxNumberOnCellProps = reader.loadProperties(entityClass.getSimpleName().toLowerCase());
            Integer maxNumberOnCell = Integer.valueOf(maxNumberOnCellProps.getProperty(numberOnCell));
            maxNumberOnCellMap.put(entityClass, maxNumberOnCell);
        }
    }

    private Map<Class<? extends EntityAI>, Integer> getEatingProbability(Class<? extends EntityAI> hunterClass) {
        Map<Class<? extends EntityAI>, Integer> victimMap = new HashMap<>();
        String hunter = hunterClass.getSimpleName().toLowerCase();
        BaseProperties reader = new BaseProperties(FOLDER);
        Properties victimProbability = reader.loadProperties(hunter);
        for (Class<? extends EntityAI> victimClass : entityClassList) {
            String name = victimClass.getSimpleName();
            Integer probability = Integer.valueOf(victimProbability.getProperty(name.toLowerCase()));
            victimMap.put(victimClass, probability);
        }
        return victimMap;
    }
}
