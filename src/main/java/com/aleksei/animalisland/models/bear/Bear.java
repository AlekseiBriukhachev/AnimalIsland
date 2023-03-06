package com.aleksei.animalisland.models.bear;


import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.Location;
import com.aleksei.animalisland.repositories.Predator;
import lombok.Data;

@Data
public class Bear extends Animal implements Predator {


    public Bear(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
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
