package com.aleksei.animalisland.simulation.animals;

@AnimalAnnotation(
        name = "wolf",
        symbol = "\uD83D\uDC3A",
        weight = 50,
        speed = 3,
        foodAmount = 8,
        maxNumberPerLocation = 30,
        eatProbability = {0, 0, 0, 0, 0, 10, 15, 60, 80, 60, 70, 15, 10, 40, 0, 0}
)
public class Wolf extends Animal {
}
