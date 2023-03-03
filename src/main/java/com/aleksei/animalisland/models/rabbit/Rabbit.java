package com.aleksei.animalisland.models.rabbit;


import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.repositories.Herbivores;
import lombok.Data;

@Data
public class Rabbit extends Animal implements Herbivores {
    public Rabbit(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Rabbit{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}

