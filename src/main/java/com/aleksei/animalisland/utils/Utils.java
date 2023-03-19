package com.aleksei.animalisland.utils;

import com.aleksei.animalisland.models.Animal;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    @NotNull
    public static List<? extends Animal<?>> getAnimals(List<? extends Animal<?>> animals, int eatProbability) {
        synchronized (animals){
            if (animals.size() > 1){
                Animal otherAnimal = animals.get(ThreadLocalRandom.current().nextInt(animals.size()));
                if (ThreadLocalRandom.current().nextInt() <= eatProbability){
                    animals.remove(otherAnimal);
                }
            }
        }
        return animals;
    }
}
