package com.aleksei.animalisland.simulation.animals;

@AnimalAnnotation(
        name = "Duck",
        symbol = "\uD83E\uDD86",
        weight = 1,
        speed = 4,
        foodAmount = 0.15,
        maxNumberPerLocation = 200,
        eatProbability = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100}
)
public class Duck extends Animal {

}
