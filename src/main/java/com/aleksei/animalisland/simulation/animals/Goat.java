package com.aleksei.animalisland.simulation.animals;

@AnimalAnnotation(
        name = "Goat",
        symbol = "\uD83D\uDC10",
        weight = 60,
        speed = 3,
        foodAmount = 10,
        maxNumberPerLocation = 140,
        eatProbability = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100}
)
public class Goat extends Animal {
}
