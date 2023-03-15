package com.aleksei.animalisland.models.animals;


public class Snake extends Animal implements Predator {
    public Snake(int weight, int speed, int foodQuantity) {
        super("Snake", "\uD83D\uDC0D", 15
                , 1, 3);
    }
}
