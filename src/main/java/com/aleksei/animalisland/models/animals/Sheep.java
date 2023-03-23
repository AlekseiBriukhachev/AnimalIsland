package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.AppConfig;

public class Sheep extends Animal {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    public Sheep() {
        super("Sheep", "\uD83D\uDC11",
                CONFIG.getWeight(Sheep.class),
                CONFIG.getSpeed(Sheep.class),
                CONFIG.getFoodQuantity(Sheep.class));
    }
}
