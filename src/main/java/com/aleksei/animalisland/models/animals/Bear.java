package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.Location;
import com.aleksei.animalisland.repositories.Predator;
import com.aleksei.animalisland.services.Position;
import lombok.Data;

public class Bear extends Animal {


    public Bear(double weight, int speed, double foodQuantity, Position position) {
        super(weight, speed, foodQuantity, position);
    }

    @Override
    public String toString() {
        return "Bear{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}
