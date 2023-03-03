package com.aleksei.animalisland.model;

import com.aleksei.island.utils.Herbivores;

public class Mouse extends Animal implements Herbivores {
    public Mouse(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Mouse{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}
