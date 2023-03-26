package com.aleksei.animalisland.models.animals;

import com.aleksei.animalisland.repository.Herbivore;
import com.aleksei.animalisland.repository.Predator;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public abstract class Animal extends EntityAI {
    private Integer id;
    private int speed;
    private double foodAmount;

    private int[] eatingProbability;

    public Animal(String name, String symbol, double weight
            , int speed, double foodAmount, int[] eatingProbability) {
        super(name, symbol, weight);
        this.speed = speed;
        this.foodAmount = foodAmount;
        this.eatingProbability = eatingProbability;
    }
    public Animal(){
    }

    public boolean isNew(){
        return id == null;
    }

}