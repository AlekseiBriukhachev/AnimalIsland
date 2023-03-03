package com.aleksei.animalisland.models;

import com.aleksei.animalisland.repositories.Food;
import com.aleksei.animalisland.repositories.gauge.AnimalGauge;

public class Plant implements Food {
    private double weight;
    private final AnimalGauge amount;
    private final int foodValue;
    private final int growingRate;

    public Plant(double weight, int foodValue, int growingRate, int max) {
        this.weight = weight;
        this.foodValue = foodValue;
        this.growingRate = growingRate;
        this.amount = new AnimalGauge(0, max/2, max);
    }

    @Override
    public int getFoodValue() {
        return foodValue;
    }

    @Override
    public boolean eaten() {
        if (amount.getCurrent() >= getFoodValue()){
            amount.minus(getFoodValue());
            return true;
        }
        return false;
    }
    public void update(){
        amount.plus(growingRate);
    }

    @Override
    public String toString() {
        return "Plant{" +
                "amount=" + amount +
                '}';
    }
}
