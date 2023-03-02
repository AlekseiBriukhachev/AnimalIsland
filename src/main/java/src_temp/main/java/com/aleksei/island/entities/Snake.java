package src_temp.main.java.com.aleksei.island.entities;

import com.aleksei.island.utils.Predator;

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
