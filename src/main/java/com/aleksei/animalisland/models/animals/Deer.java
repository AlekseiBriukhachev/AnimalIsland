package com.aleksei.animalisland.models.animals;


public class Deer extends Animal implements Herbivore {
    public Deer(int weight, int speed, int foodQuantity) {
        super("Deer", "\uD83E\uDD8C", 300
                , 4, 50);
    }
}
