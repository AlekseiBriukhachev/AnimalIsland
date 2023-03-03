package com.aleksei.animalisland.model;

import com.aleksei.island.utils.Herbivores;

public class Boar extends Animal implements Herbivores {


    public Boar(Location location, double weight, int speed, double foodQuantity) {
        super(location, weight, speed, foodQuantity);
    }

    public Boar(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Boar{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }

}
