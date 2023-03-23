package com.aleksei.animalisland.simulation.animals;

import com.aleksei.animalisland.simulation.EntityAnnotation;

@EntityAnnotation(
        name = "Eagle",
        symbol = "\uD83E\uDD85",
        weight = 6,
        speed = 3,
        foodAmount = 1,
        maxNumberPerLocation = 20,
        eatProbability = {0, 0, 10, 0, 0, 0, 0, 90, 90, 0, 0, 0, 0, 80, 0, 0}
)
public class Eagle  {

}
