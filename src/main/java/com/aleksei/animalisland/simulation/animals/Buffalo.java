package com.aleksei.animalisland.simulation.animals;


import com.aleksei.animalisland.simulation.EntityAnnotation;

@EntityAnnotation(
        name = "Buffalo",
        symbol = "\uD83D\uDC03",
        weight = 700,
        speed = 3,
        foodAmount = 100,
        maxNumberPerLocation = 10,
        eatProbability = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100})
public class Buffalo {
}
