package com.aleksei.animalisland.models.animals;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.services.Position;
import lombok.Getter;
import lombok.Setter;

public class Boar extends Animal {
    @Getter
    @Setter
    private Position position;


    public Boar(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Boar{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }

}
