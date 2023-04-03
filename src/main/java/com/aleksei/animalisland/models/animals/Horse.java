package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;

public class Horse extends Animal implements Herbivore {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Horse() {
        super("Horse", "\uD83D\uDC0E",
                CONFIG.getWeight(Horse.class),
                CONFIG.getSpeed(Horse.class),
                CONFIG.getFoodQuantity(Horse.class));
    }
}