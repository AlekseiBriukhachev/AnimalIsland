package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.Predator;

public class Bear extends Animal implements Predator {
    public Bear(double weight, int speed, double foodAmount) {
        super("Bear", "\uD83D\uDC3B", weight
                , speed, foodAmount);
    }
}
