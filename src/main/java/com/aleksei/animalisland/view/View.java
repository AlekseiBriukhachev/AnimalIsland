package com.aleksei.animalisland.view;


import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.Island.Island;
import com.aleksei.animalisland.models.animals.EntityAI;
import com.aleksei.animalisland.config.EntityConfig;
import com.aleksei.animalisland.models.plant.Grass;
import com.aleksei.animalisland.utils.enumartion.AnimalType;
import com.aleksei.animalisland.utils.factories.AnimalFactory;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class View {
    private  final EntityConfig entityConfig = EntityConfig.getInstance();

    public void printIsland(Island island, String taskName) {
        log.info("Start task: " + taskName);
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(this::print);
        log.info("<------------------------------Next Generation----------------------------->");
    }

    private void print(Location location) {
        Grass grass = new Grass();

        Map<String, Integer> cellMap = new HashMap<>();

        for (Class<? extends EntityAI> inhabitantClass : entityConfig.entityClassList) {
            int count = location.getAnimals().stream()
                    .mapToInt(value -> value.getClass().equals(inhabitantClass) ? 1 : 0)
                    .sum();
                cellMap.put(AnimalFactory.getInstance().create(AnimalType.valueOf(inhabitantClass.getSimpleName().toUpperCase())).getSymbol(), count);
        }
        cellMap.put(grass.getSymbol(), location.getPlants().size());
        log.info("Location info: " + cellMap);
    }
}
