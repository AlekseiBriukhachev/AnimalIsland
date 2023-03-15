package com.aleksei.animalisland.models.animals;


public class Eagle extends Animal implements Predator {
    public Eagle(int weight, int speed, int foodQuantity) {
        super("Eagle", "\uD83E\uDD85", weight
                , speed, foodQuantity);
    }
}
