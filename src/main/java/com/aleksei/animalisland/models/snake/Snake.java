package com.aleksei.animalisland.models.snake;


import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.repositories.Predator;
import lombok.Data;

@Data
public class Snake extends Animal implements Predator {
    public Snake(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Snake{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}
