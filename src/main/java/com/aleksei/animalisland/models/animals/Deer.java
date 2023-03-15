package com.aleksei.animalisland.models.animals;


public class Deer extends Animal implements Herbivore {
    public Deer(int weight, int speed, int foodQuantity) {
        super("Deer", "\uD83E\uDD8C", weight
                , speed, foodQuantity);
    }
}
