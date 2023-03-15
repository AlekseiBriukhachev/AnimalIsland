package com.aleksei.animalisland.models.animals;


public class Horse extends Animal implements Herbivore {
    public Horse(int weight, int speed, int foodQuantity) {
        super("Horse", "\uD83D\uDC0E", 400
                , 4, 60);
    }
}