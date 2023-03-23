package com.aleksei.animalisland.simulation.animals;

import com.aleksei.animalisland.simulation.EntityAnnotation;

@EntityAnnotation(
        name = "Rabbit",
        symbol = "\uD83D\uDC30",
        weight = 2,
        speed = 2,
        foodAmount = 0.45,
        maxNumberPerLocation = 150,
        eatProbability = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100}
)
public class Rabbit {
}
