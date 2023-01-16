package com.aleksei.entities;

public class Duck extends Animal {
    private int weight;
    private int speed;
    private double foodQuantity;

    public Duck(int weight, int speed, double foodQuantity) {
        this.weight = weight;
        this.speed = speed;
        this.foodQuantity = foodQuantity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
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
}
