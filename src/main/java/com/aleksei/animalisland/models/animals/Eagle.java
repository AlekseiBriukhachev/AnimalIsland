package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.models.Animal;

public class Eagle extends Animal {
    public Eagle(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Eagle{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}
