package com.aleksei.animalisland.simulation.animals;

import com.aleksei.animalisland.simulation.EntityAnnotation;

@EntityAnnotation(
        name = "Deer",
        symbol = "\uD83E\uDD8C",
        weight = 300,
        speed = 4,
        foodAmount = 20,
        maxNumberPerLocation = 50,
        eatProbability = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100}
)
public class Deer {
}
