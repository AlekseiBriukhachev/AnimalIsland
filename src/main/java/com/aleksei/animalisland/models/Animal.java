package com.aleksei.animalisland.models;

import com.aleksei.animalisland.services.Position;
import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@Data
public abstract class Animal<T extends Animal<T>> {
    private boolean isAlive = true;
    private final double weight;
    private final int speed;
    private final double foodQuantity;

    public Animal(double weight, int speed, double foodQuantity) {
        this.weight = weight;
        this.speed = speed;
        this.foodQuantity = foodQuantity;

    }
}
