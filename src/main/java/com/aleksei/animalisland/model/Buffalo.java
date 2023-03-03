package com.aleksei.animalisland.model;

import com.aleksei.island.utils.Herbivores;

public class Buffalo extends Animal implements Herbivores {

    public Buffalo(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Buffalo{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}
