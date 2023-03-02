package src_temp.main.java.com.aleksei.island.entities;

import com.aleksei.island.utils.Herbivores;

public class Duck extends Animal implements Herbivores {

    public Duck(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }
    @Override
    public String toString() {
        return "Duck{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}
