package com.aleksei.animalisland.models.animals;


public class Mouse extends Animal implements Herbivore, Predator {
    public Mouse(double weight, int speed, double foodQuantity) {
        super("Mouse", "\uD83D\uDC01", weight
                , speed, foodQuantity);
    }
}
