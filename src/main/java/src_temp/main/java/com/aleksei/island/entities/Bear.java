package src_temp.main.java.com.aleksei.island.entities;


import com.aleksei.island.utils.Predator;

public class Bear extends Animal implements Predator {


    public Bear(Location location, double weight, int speed, double foodQuantity) {
        super(location, weight, speed, foodQuantity);
    }

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
