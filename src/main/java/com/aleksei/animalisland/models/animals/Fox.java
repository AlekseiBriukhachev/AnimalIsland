package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.models.Animal;

public class Fox extends Animal {
    public Fox(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Fox{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}
