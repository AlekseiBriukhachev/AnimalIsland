package com.aleksei.animalisland.models.animals;


public class Rabbit extends Animal implements Herbivore {
    public Rabbit(int weight, int speed, double foodQuantity) {
        super("Rabbit", "\uD83D\uDC30"
                , 2, 2, 0.45F);
    }
}
