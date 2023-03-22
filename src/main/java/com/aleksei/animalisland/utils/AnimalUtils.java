package com.aleksei.animalisland.utils;

import com.aleksei.animalisland.simulation.animals.*;

import java.util.HashMap;
import java.util.Map;

public class AnimalUtils {
    public static int getEatProbability(Animal animal, int[] eatProbabilityArray){
        Map<Animal, Integer> eatProbabilityMap = new HashMap<>();

        if (animal instanceof Wolf) {
            eatProbabilityMap.put(animal, eatProbabilityArray[0]);
        } else if (animal instanceof Snake) {
            eatProbabilityMap.put(animal, eatProbabilityArray[1]);
        }else if (animal instanceof Fox) {
            eatProbabilityMap.put(animal, eatProbabilityArray[2]);
        }else if (animal instanceof Bear) {
            eatProbabilityMap.put(animal, eatProbabilityArray[3]);
        }else if (animal instanceof Eagle) {
            eatProbabilityMap.put(animal, eatProbabilityArray[4]);
        }else if (animal instanceof Horse) {
            eatProbabilityMap.put(animal, eatProbabilityArray[5]);
        }else if (animal instanceof Deer) {
            eatProbabilityMap.put(animal, eatProbabilityArray[6]);
        }else if (animal instanceof Rabbit) {
            eatProbabilityMap.put(animal, eatProbabilityArray[7]);
        }else if (animal instanceof Mouse) {
            eatProbabilityMap.put(animal, eatProbabilityArray[8]);
        }else if (animal instanceof Goat) {
            eatProbabilityMap.put(animal, eatProbabilityArray[9]);
        }else if (animal instanceof Sheep) {
            eatProbabilityMap.put(animal, eatProbabilityArray[10]);
        }else if (animal instanceof Boar) {
            eatProbabilityMap.put(animal, eatProbabilityArray[11]);
        }else if (animal instanceof Buffalo) {
            eatProbabilityMap.put(animal, eatProbabilityArray[12]);
        }else if (animal instanceof Duck) {
            eatProbabilityMap.put(animal, eatProbabilityArray[13]);
        }else if (animal instanceof Caterpillar) {
            eatProbabilityMap.put(animal, eatProbabilityArray[14]);
        }
        int eatProbability = 0;
        for (Map.Entry<Animal, Integer> entry : eatProbabilityMap.entrySet()){
            eatProbability = entry.getValue();
        }
        return eatProbability;
    }
}
