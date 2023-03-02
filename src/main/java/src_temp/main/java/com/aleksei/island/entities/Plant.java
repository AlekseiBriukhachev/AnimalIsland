package src_temp.main.java.com.aleksei.island.entities;

public class Plant {
    private double weight;

    public Plant(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "weight=" + weight +
                '}';
    }
}
