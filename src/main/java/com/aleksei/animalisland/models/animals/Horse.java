package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;
import com.aleksei.animalisland.repository.Herbivore;

public class Horse extends Animal {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Horse() {
        super("Horse", "\uD83D\uDC0E",
                CONFIG.getWeight(Horse.class),
                CONFIG.getSpeed(Horse.class),
                CONFIG.getFoodQuantity(Horse.class));
    }
}