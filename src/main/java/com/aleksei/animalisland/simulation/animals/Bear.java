package com.aleksei.animalisland.simulation.animals;

import com.aleksei.animalisland.simulation.EntityAnnotation;
import com.aleksei.animalisland.simulation.Island.Location;
import com.aleksei.animalisland.utils.AnimalUtils;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@EntityAnnotation(
        name = "Bear",
        symbol = "\uD83D\uDC3B",
        weight = 500,
        speed = 2,
        foodAmount = 2,
        maxNumberPerLocation = 80,
        eatProbability = {0, 80, 0, 0, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0, 0})
public class Bear implements Animal {

    @Override
    public void eat(Location location) {

        IntStream.range(0, location.getAnimals().size())
                .forEachOrdered(i -> animalHunt(location));
    }

    private void animalHunt(Location location) {

        EntityAnnotation entityAnnotation = this.getClass().getAnnotation(EntityAnnotation.class);
        int[] eatProbabilityArray = entityAnnotation.eatProbability();
        for (Animal animal : location.getAnimals()){
            int eatProbability = AnimalUtils.getEatProbability(animal, eatProbabilityArray);

            int randomProbability = ThreadLocalRandom.current().nextInt(100);
            if (eatProbability != 0 && eatProbability >= randomProbability){
                location.getAnimals().remove(animal);
            }
        }
    }

    @Override
    public void move() {

    }

    @Override
    public void reproduce() {

    }
}
