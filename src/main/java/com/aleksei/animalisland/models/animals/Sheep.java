package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;
import com.aleksei.animalisland.repository.Herbivore;

public class Sheep extends Animal {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Sheep() {
        super("Sheep", "\uD83D\uDC11",
                CONFIG.getWeight(Sheep.class),
                CONFIG.getSpeed(Sheep.class),
                CONFIG.getFoodQuantity(Sheep.class),
                CONFIG.getEatingProbability(Sheep.class));
    }
}
