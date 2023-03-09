package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.models.Animal;

public class Snake extends Animal {
    public Snake(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Snake{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}
