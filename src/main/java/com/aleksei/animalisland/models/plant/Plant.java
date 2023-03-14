package com.aleksei.animalisland.models.plant;


import com.aleksei.animalisland.models.animal.EntityAI;

public abstract class Plant extends EntityAI {
    public Plant(String name, String symbol, float weight) {
        super(name, symbol, weight);
    }
}
