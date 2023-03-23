package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.AppConfig;

public class Goat extends Animal {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    public Goat() {
        super("Goat", "\uD83D\uDC10",
                CONFIG.getWeight(Goat.class),
                CONFIG.getSpeed(Goat.class),
                CONFIG.getFoodQuantity(Goat.class));
    }
}
