package com.aleksei.animalisland.models.sheep;


import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.repositories.Herbivores;
import lombok.Data;

@Data
public class Sheep extends Animal implements Herbivores {
    public Sheep(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Sheep{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}
