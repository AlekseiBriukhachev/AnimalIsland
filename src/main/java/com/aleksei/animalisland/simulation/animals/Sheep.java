package com.aleksei.animalisland.simulation.animals;

@AnimalAnnotation(
        name = "Sheep",
        symbol = "\uD83D\uDC11",
        weight = 70,
        speed = 3,
        foodAmount = 15,
        maxNumberPerLocation = 140,
        eatProbability = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100}
)
public class Sheep extends Animal {
}
