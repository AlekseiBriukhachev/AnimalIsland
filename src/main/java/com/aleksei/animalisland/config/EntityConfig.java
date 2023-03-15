package com.aleksei.animalisland.config;


import com.aleksei.animalisland.models.animals.*;
import com.aleksei.animalisland.models.plant.Grass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EntityConfig {
//    private static final String FOLDER = "inhabitantprops";
//    private static final String numberOnCell = "numberOnCell";
    private static final AppConfig CONFIG = AppConfig.getAppConfig();

    public final List<Class<? extends EntityAI>> entityClassList = List.of(Buffalo.class, Bear.class,
            Caterpillar.class, Deer.class, Duck.class, Eagle.class, Fox.class, Goat.class, Horse.class,
            Mouse.class, Rabbit.class, Sheep.class, Snake.class, Wolf.class, Boar.class, Grass.class);

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
//        BaseProperties reader = new BaseProperties(FOLDER);
        for (Class<? extends EntityAI> entityClass : entityClassList) {
//            Properties maxNumberOnCellProps = reader.loadProperties(entityClass.getSimpleName().toLowerCase());
            Integer maxNumberOnCell = CONFIG.getMaxNumberPerLocation(entityClass.getSimpleName().toLowerCase());

//                    Integer.valueOf(maxNumberOnCellProps.getProperty(numberOnCell));
            maxNumberOnCellMap.put(entityClass, maxNumberOnCell);
        }
    }

    public Map<Class<? extends EntityAI>, Integer> getEatingProbability(Class<? extends EntityAI> hunterClass) {

        List<String> eatingProbability = List.of(CONFIG.getEatingProbability(hunterClass));

//        return IntStream.range(0, entityClassList.size())
//                .boxed()
//                .collect(Collectors.toMap(entityClassList::get, eatingProbability::get))
        return null;
    }
}
