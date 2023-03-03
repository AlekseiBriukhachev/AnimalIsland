package com.aleksei.animalisland.models.eagle;


import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.repositories.Predator;
import lombok.Data;

@Data
public class Eagle extends Animal implements Predator {
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
