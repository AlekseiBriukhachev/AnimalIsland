package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.models.Animal;

public class Duck extends Animal {

    public Duck(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Duck{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}
