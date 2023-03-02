package src_temp.main.java.com.aleksei.island.entities;

import com.aleksei.island.utils.Predator;

public class Eagle extends Animal implements Predator {
    public Eagle(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Eagle{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}
