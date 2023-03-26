package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;
import com.aleksei.animalisland.repository.Herbivore;

public class Buffalo extends Animal {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Buffalo() {
        super("Buffalo", "\uD83D\uDC03",
                CONFIG.getWeight(Buffalo.class),
                CONFIG.getSpeed(Buffalo.class),
                CONFIG.getFoodQuantity(Buffalo.class),
                CONFIG.getEatingProbability(Buffalo.class));
    }
}
