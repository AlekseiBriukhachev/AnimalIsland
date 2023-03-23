package com.aleksei.animalisland.simulation.animals;

import com.aleksei.animalisland.simulation.EntityAnnotation;

@EntityAnnotation(
        name = "Fox",
        symbol = "\uD83E\uDD8A",
        weight = 8,
        speed = 2,
        foodAmount = 2,
        maxNumberPerLocation = 30,
        eatProbability = {0, 0, 0, 0, 0, 0, 0, 70, 90, 0, 0, 0, 0, 60, 40, 0}
)
public class Fox  {

}
