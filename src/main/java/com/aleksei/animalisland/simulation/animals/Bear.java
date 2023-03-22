package com.aleksei.animalisland.simulation.animals;

@AnimalAnnotation(
        name = "Bear",
        symbol = "\uD83D\uDC3B",
        weight = 500,
        speed = 2,
        foodAmount = 2,
        maxNumberPerLocation = 80,
        eatProbability = {0, 80, 0, 0, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0, 0})
public class Bear extends Animal {

}
