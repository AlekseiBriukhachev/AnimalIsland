package com.briukhachev.aleksei.animalfactory;

public class Plants {
    private final int weight;
    private final int foodValue;
    private final int increaseRate;

    public Plants(int weight, int foodValue, int increaseRate) {
        this.weight = weight;
        this.foodValue = foodValue;
        this.increaseRate = increaseRate;
    }

    public int getWeight() {
        return weight;
    }

    public int getFoodValue() {
        return foodValue;
    }

    public int getIncreaseRate() {
        return increaseRate;
    }
}
