package com.briukhachev.aleksei.animalplant;

public abstract class Organism {
    private double weight;
    private double foodQuantity;
    private int speed;
    private boolean isEatable;
    private int probabilityBeEaten;

    public Organism(double weight, boolean isEatable) {
        this.weight = weight;
        this.isEatable = isEatable;
    }

    public Organism(double weight, int speed, double foodQuantity, boolean isEatable) {
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

    public double getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(double foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isEatable() {
        return isEatable;
    }

    public void setEatable(boolean eatable) {
        isEatable = eatable;
    }

    public int getProbabilityBeEaten() {
        return probabilityBeEaten;
    }

    public void setProbabilityBeEaten(int probabilityBeEaten) {
        this.probabilityBeEaten = probabilityBeEaten;
    }

    @Override
    public String toString() {
        return "Organism{" +
                "weight=" + weight +
                ", foodQuantity=" + foodQuantity +
                ", speed=" + speed +
                '}';
    }
}
