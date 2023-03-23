package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.AppConfig;

public class Boar extends Animal {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    public Boar() {
        super("Boar", "\uD83D\uDC17",
                CONFIG.getWeight(Boar.class),
                CONFIG.getSpeed(Boar.class),
                CONFIG.getFoodQuantity(Boar.class));
    }
}
