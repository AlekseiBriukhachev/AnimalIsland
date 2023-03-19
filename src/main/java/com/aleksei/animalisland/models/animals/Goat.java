package com.aleksei.animalisland.models.animals;


public class Goat extends Animal implements Herbivore {
    public Goat(int weight, int speed, int foodQuantity) {
        super("Goat", "\uD83D\uDC10", weight
                , speed, foodQuantity);
    }
}
