package com.aleksei.animalisland.model;

import com.aleksei.island.utils.Herbivores;

public class Goat extends Animal implements Herbivores {
    public Goat(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Goat{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}
