package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.models.Animal;

public class Wolf extends Animal {
    public Wolf(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Wolf{}" + this.getSpeed() + ", " + this.getWeight();
    }
}
