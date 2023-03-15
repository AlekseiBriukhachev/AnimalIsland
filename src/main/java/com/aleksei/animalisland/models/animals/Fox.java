package com.aleksei.animalisland.models.animals;


public class Fox extends Animal implements Predator {

    public Fox(int weight, int speed, int foodQuantity) {
        super("Fox", "\uD83E\uDD8A", 8
                , 2, 2);
    }
}
