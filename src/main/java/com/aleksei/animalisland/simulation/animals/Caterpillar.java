package com.aleksei.animalisland.simulation.animals;

@AnimalAnnotation(
        name = "Caterpillar",
        symbol = "\uD83D\uDC1B",
        weight = 0.01,
        speed = 0,
        foodAmount = 0,
        maxNumberPerLocation = 1000,
        eatProbability = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100})
public class Caterpillar extends Animal {
}