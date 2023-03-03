package com.aleksei.animalisland.models.fox;


import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.repositories.Predator;
import lombok.Data;

@Data
public class Fox extends Animal implements Predator {
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
