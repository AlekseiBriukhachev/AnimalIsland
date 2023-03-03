package com.aleksei.animalisland.models.boar;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.Location;
import com.aleksei.animalisland.repositories.Herbivores;
import lombok.Data;

@Data
public class Boar extends Animal implements Herbivores {


    public Boar(Location location, double weight, int speed, double foodQuantity) {
        super(location, weight, speed, foodQuantity);
    }

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
