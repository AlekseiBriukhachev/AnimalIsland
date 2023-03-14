package com.aleksei.animalisland.models.animal;

import lombok.Getter;
import lombok.Setter;

public abstract class Animal extends EntityAI implements Predator, Herbivore {
    @Getter
    @Setter
    private int speed;
    @Getter
    @Setter
    private float foodAmount;

    public Animal(String name, String symbol, float weight
            , int speed, float foodAmount) {
        super(name, symbol, weight);
        this.speed = speed;
        this.foodAmount = foodAmount;
    }

}