package src_temp.main.java.com.aleksei.island.entities;

import com.aleksei.island.utils.Herbivores;

public class Rabbit extends Animal implements Herbivores {
    public Rabbit(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Rabbit{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}

