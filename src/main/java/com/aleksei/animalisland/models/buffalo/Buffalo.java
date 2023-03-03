package com.aleksei.animalisland.models.buffalo;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.repositories.Herbivores;
import lombok.Data;

@Data
public class Buffalo extends Animal implements Herbivores {

    public Buffalo(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Buffalo{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}
