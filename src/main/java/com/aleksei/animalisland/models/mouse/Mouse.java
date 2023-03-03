package com.aleksei.animalisland.models.mouse;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.repositories.Herbivores;
import lombok.Data;

@Data
public class Mouse extends Animal implements Herbivores {
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
