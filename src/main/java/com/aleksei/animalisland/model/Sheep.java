package com.aleksei.animalisland.model;

import com.aleksei.island.utils.Herbivores;

public class Sheep extends Animal implements Herbivores {
    public Sheep(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Sheep{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}
