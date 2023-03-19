package com.aleksei.animalisland.models.animals;

import com.aleksei.animalisland.repository.AnimalInfo;
import com.aleksei.animalisland.utils.stats.NumberGauge;
import com.aleksei.animalisland.utils.stats.NumberGaugeInfo;
import lombok.Getter;
import lombok.Setter;

public abstract class Animal<T extends Animal<T>> extends EntityAI implements Predator, Herbivore, AnimalInfo {
    @Getter
    @Setter
    private int speed;
    @Getter
    @Setter
    private double foodAmount;
    @Getter
    private final NumberGauge health = new NumberGauge(0, 100);

    public Animal(String name, String symbol, double weight
            , int speed, double foodAmount) {
        super(name, symbol, weight);
        this.speed = speed;
        this.foodAmount = foodAmount;
    }
    public boolean isHungry() {
        return getHealth().part() < 70d;
    }

}