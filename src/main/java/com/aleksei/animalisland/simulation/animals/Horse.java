package com.aleksei.animalisland.simulation.animals;

@AnimalAnnotation(
        name = "Horse",
        symbol = "\uD83D\uDC0E",
        weight = 400,
        speed = 4,
        foodAmount = 60,
        maxNumberPerLocation = 20,
        eatProbability = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100}
)
public class Horse extends Animal {
}