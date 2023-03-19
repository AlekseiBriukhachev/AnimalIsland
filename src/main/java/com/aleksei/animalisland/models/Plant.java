package com.aleksei.animalisland.models;

import lombok.Data;

@Data
public class Plant {
    private double weight;
    private final int foodValue;
    private final int growingRate;

    public Plant(double weight, int foodValue, int growingRate) {
        this.weight = weight;
        this.foodValue = foodValue;
        this.growingRate = growingRate;
    }


    @Override
    public String toString() {
        return "Plant{" +
                "weight=" + weight +
                ", foodValue=" + foodValue +
                ", growingRate=" + growingRate +
                '}';
    }
}
