package com.aleksei.animalisland.models.wolf;


import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.repositories.Predator;
import lombok.Data;

@Data
public class Wolf extends Animal implements Predator {
    public Wolf(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Wolf{}" + this.getSpeed() + ", " + this.getWeight();
    }
}
