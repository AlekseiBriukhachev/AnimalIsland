package com.aleksei.animalisland.simulation.animals;


@AnimalAnnotation(
        name = "Boar",
        symbol = "\uD83D\uDC17",
        weight = 400,
        speed = 2,
        foodAmount = 50,
        maxNumberPerLocation = 80,
        eatProbability = {0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 90, 100})
public class Boar extends Animal {
}
