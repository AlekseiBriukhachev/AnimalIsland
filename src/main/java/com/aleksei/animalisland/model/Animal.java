package com.aleksei.animalisland.model;

import lombok.Data;

import java.util.Map;

@Data
public abstract class Animal extends BaseEntity {
    private int speed;
    private double foodQuantity;
    private Map<String, Integer> eatProbability;
    public Animal(){}

    public Animal(Location location, double weight, int maxNumberPerLocation, String symbol, int speed, double foodQuantity, Map<String, Integer> eatProbability) {
        super(location, weight, maxNumberPerLocation, symbol);
        this.speed = speed;
        this.foodQuantity = foodQuantity;
        this.eatProbability = eatProbability;
    }
}
