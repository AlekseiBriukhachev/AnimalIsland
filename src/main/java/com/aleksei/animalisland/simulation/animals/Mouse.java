package com.aleksei.animalisland.simulation.animals;

@AnimalAnnotation(
        name = "Mouse",
        symbol = "\uD83D\uDC01",
        weight = 0.05,
        speed = 1,
        foodAmount = 0.01,
        maxNumberPerLocation = 500,
        eatProbability = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100}
)
public class Mouse extends Animal {

}
