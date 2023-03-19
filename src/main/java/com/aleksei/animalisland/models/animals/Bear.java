package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.Location;
import com.aleksei.animalisland.services.Position;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

public class Bear extends Animal {
    @Getter
    @Setter
    private Position position;


    public Bear(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
        this.position = new Position(
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt()
        );
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
