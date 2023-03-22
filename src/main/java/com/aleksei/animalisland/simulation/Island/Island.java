package com.aleksei.animalisland.simulation.Island;


import com.aleksei.animalisland.config.AppConfig;
import com.aleksei.animalisland.dao.SimulationResult;
import com.aleksei.animalisland.simulation.Simulation;
import com.aleksei.animalisland.simulation.animals.Animal;
import com.aleksei.animalisland.simulation.animals.AnimalAnnotation;
import com.aleksei.animalisland.simulation.plant.Grass;
import com.aleksei.animalisland.simulation.plant.Plant;
import com.aleksei.animalisland.utils.AnimalFactory;
import com.aleksei.animalisland.utils.enums.AnimalType;
import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Data
public class Island implements Simulation {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    private final int width = CONFIG.getIslandWidth();
    private final int height = CONFIG.getIslandHeight();
    private final Location[][] island = new Location[width][height];

    public Island() {
    }

    private void init() {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                Location location = new Location();
                island[x][y] = location;
                addEntity(location);

            }
        }
    }

    private void addEntity(Location location) {

        int animalType = ThreadLocalRandom.current().nextInt(AnimalType.values().length + 1);
        int maxNumberOnCell = 0;
        int number;


        if (animalType <= AnimalType.values().length) {

            Animal animal = AnimalFactory.getInstance().create(AnimalType.values()[animalType]);

            AnimalAnnotation animalAnnotation = animal.getClass().getAnnotation(AnimalAnnotation.class);
            maxNumberOnCell = animalAnnotation.maxNumberPerLocation();

            number = (int) (Math.random() * maxNumberOnCell);
            IntStream.rangeClosed(0, number).forEachOrdered(value -> location.getAnimals().add(animal));
        }else {
            number = (int) (Math.random() * maxNumberOnCell);
            IntStream.rangeClosed(0, number).forEachOrdered(value -> location.getPlants().add(new Grass()));
        }
    }


    @Override
    public SimulationResult startSimulation(Island island) {
        return null;
    }
}
