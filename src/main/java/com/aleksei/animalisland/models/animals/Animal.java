package com.aleksei.animalisland.models.animals;

import com.aleksei.animalisland.repository.Herbivore;
import com.aleksei.animalisland.repository.Predator;
import lombok.Getter;
import lombok.Setter;

public abstract class Animal extends EntityAI {
    @Getter
    @Setter
    private int speed;
    @Getter
    @Setter
    private double foodAmount;

    public Animal(String name, String symbol, double weight
            , int speed, double foodAmount) {
        super(name, symbol, weight);
        this.speed = speed;
        this.foodAmount = foodAmount;
    }
    public Animal(){
    }

}