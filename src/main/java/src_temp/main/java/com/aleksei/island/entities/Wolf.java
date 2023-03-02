package src_temp.main.java.com.aleksei.island.entities;

import com.aleksei.island.utils.Predator;

public class Wolf extends Animal implements Predator {
    public Wolf(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Wolf{}" + this.getSpeed() + ", " + this.getWeight();
    }
}
