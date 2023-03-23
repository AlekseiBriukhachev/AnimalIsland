package com.aleksei.animalisland.simulation.animals;

import com.aleksei.animalisland.simulation.EntityAnnotation;

@EntityAnnotation(
        name = "Snake",
        symbol = "\uD83D\uDC0D",
        weight = 15,
        speed = 1,
        foodAmount = 3,
        maxNumberPerLocation = 30,
        eatProbability = {0, 0, 15, 0, 0, 0, 0, 20, 40, 0, 0, 0, 0, 10, 0, 0}
)
public class Snake {
}
