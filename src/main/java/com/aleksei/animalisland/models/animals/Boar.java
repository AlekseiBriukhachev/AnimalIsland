package com.aleksei.animalisland.models.animals;


public class Boar extends Animal implements Herbivore, Predator {
    public Boar(int weight, int speed, int foodQuantity) {
        super("Boar", "\uD83D\uDC17", weight
                , speed, foodQuantity);
    }
}
