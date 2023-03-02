package src_temp.main.java.com.aleksei.island.entities;

import com.aleksei.island.utils.Herbivores;

public class Deer extends Animal implements Herbivores {
    public Deer(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Deer{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}

