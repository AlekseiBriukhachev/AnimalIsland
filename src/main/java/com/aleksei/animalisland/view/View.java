package com.aleksei.animalisland.view;


import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.Island.Island;
import com.aleksei.animalisland.models.animals.EntityAI;
import com.aleksei.animalisland.config.EntityConfig;
import com.aleksei.animalisland.models.plant.Grass;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class View {
    EntityConfig entityConfig = new EntityConfig();

    public void printIsland(Island island, String taskName) {
        System.out.println(taskName);
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(this::print);
        System.out.println("<------------------------------Next Generation----------------------------->");
    }

    private void print(Location location) {
        Grass grass = new Grass();
        Map<String, Integer> cellMap;
        cellMap = new HashMap<>();
        int count;
        for (Class<? extends EntityAI> inhabitantClass : entityConfig.entityClassList) {
            count = location.getAnimals().stream()
                    .mapToInt(value -> value.getClass().equals(inhabitantClass) ? 1 : 0)
                    .sum();
            try {
                cellMap.put(inhabitantClass.getConstructor().newInstance().getSymbol(), count);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        cellMap.put(grass.getSymbol(), location.getPlants().size());
        System.out.println(cellMap);
    }
}
