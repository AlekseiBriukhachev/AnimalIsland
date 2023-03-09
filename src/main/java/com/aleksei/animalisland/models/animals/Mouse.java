package com.aleksei.animalisland.models.animals;

import com.aleksei.animalisland.models.Animal;

public class Mouse extends Animal{
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
