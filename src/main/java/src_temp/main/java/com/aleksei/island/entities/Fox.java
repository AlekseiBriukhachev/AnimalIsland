package src_temp.main.java.com.aleksei.island.entities;

import com.aleksei.island.utils.Predator;

public class Fox extends Animal implements Predator {
    public Fox(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Fox{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}
