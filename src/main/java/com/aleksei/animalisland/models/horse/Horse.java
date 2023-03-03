package com.aleksei.animalisland.models.horse;


import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.repositories.Herbivores;
import lombok.Data;

@Data
public class Horse extends Animal implements Herbivores {
    public Horse(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Horse{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}
