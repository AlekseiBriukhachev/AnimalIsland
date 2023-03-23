package com.aleksei.animalisland.simulation.animals;

import com.aleksei.animalisland.simulation.EntityAnnotation;
import com.aleksei.animalisland.simulation.Food;
import com.aleksei.animalisland.simulation.Island.Location;
import com.aleksei.animalisland.simulation.plant.Plant;
import com.aleksei.animalisland.utils.AnimalUtils;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@EntityAnnotation(
        name = "Duck",
        symbol = "\uD83E\uDD86",
        weight = 1,
        speed = 4,
        foodAmount = 0.15,
        maxNumberPerLocation = 200,
        eatProbability = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100}
)
public class Duck implements Animal, Food {

    @Override
    public void eat(Location location) {
//        if (location.getAnimals().contains(Caterpillar))

        location.getPlants().forEach(plant -> location.getPlants().remove(plant));

    }

    @Override
    public void move() {

    }

    @Override
    public void reproduce() {

    }

    @Override
    public double getFoodValue() {
        return this.getClass().getAnnotation(EntityAnnotation.class).weight();
    }

    @Override
    public boolean eaten() {
        return false;
    }
}
