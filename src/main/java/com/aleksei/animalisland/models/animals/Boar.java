package com.aleksei.animalisland.models.animals;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.Location;
import com.aleksei.animalisland.repositories.Herbivores;
import com.aleksei.animalisland.repositories.Predator;
import lombok.Data;

public class Boar extends Animal {


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
