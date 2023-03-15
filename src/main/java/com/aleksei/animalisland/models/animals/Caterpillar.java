package com.aleksei.animalisland.models.animals;


public class Caterpillar extends Animal implements Herbivore {
    public Caterpillar(double weight, int speed, int foodQuantity) {
        super("Caterpillar", "\uD83D\uDC1B", 0.01F
                , 0, 0);
    }
}
