package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.AppConfig;

public class Horse extends Animal {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    public Horse() {
        super("Horse", "\uD83D\uDC0E",
                CONFIG.getWeight(Horse.class),
                CONFIG.getSpeed(Horse.class),
                CONFIG.getFoodQuantity(Horse.class));
    }
}