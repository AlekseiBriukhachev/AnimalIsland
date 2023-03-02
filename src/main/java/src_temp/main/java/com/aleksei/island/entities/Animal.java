package src_temp.main.java.com.aleksei.island.entities;

public abstract class Animal {
    private double weight;
    private int speed;
    private double foodQuantity;
    private int maxCount;
    private boolean isAlive;
    private Location location;

    public Animal(Location location, double weight, int speed, double foodQuantity) {
        this.location = location;
        this.weight = weight;
        this.speed = speed;
        this.foodQuantity = foodQuantity;
        location.setHasAnimal(true);
        this.isAlive = true;
    }

    public Animal(double weight, int speed, double foodQuantity) {
        this.weight = weight;
        this.speed = speed;
        this.foodQuantity = foodQuantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(double foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    public void move(){
        //TODO
        System.out.println("Animal move");
    }
    public void breed(){
        //TODO
        System.out.println("animal breed");
    }
    public void die(){
        //TODO
        System.out.println("Animal die");
    }
}
