package com.aleksei.animalisland.models;

import com.aleksei.animalisland.services.Position;
import lombok.Data;

@Data
public abstract class Animal<T extends Animal<T>> {
    private boolean isAlive = true;
    private final double weight;
    private final int speed;
    private final double foodQuantity;
    private Position position;

    public Animal(double weight, int speed, double foodQuantity, Position position) {
        this.weight = weight;
        this.speed = speed;
        this.foodQuantity = foodQuantity;
        this.position = position;
    }
}
