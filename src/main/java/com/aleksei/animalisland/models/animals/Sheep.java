package com.aleksei.animalisland.models.animals;


public class Sheep extends Animal implements Herbivore {
    public Sheep(int weight, int speed, int foodQuantity) {
        super("Sheep", "\uD83D\uDC11", weight
                , speed, foodQuantity);
    }
}
