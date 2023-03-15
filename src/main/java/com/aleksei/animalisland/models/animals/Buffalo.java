package com.aleksei.animalisland.models.animals;


public class Buffalo extends Animal implements Herbivore {
    public Buffalo(int weight, int speed, int foodQuantity) {
        super("Buffalo", "\uD83D\uDC03", weight, speed
                , foodQuantity);
    }
}
