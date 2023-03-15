package com.aleksei.animalisland.models.animals;


public class Wolf extends Animal implements Predator {
    public Wolf(int weight, int speed, int foodQuantity) {
        super("Wolf", "\uD83D\uDC3A", 50
                , 3, 8);
    }
}
