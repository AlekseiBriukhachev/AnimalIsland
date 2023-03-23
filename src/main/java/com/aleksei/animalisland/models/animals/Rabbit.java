package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.AppConfig;

public class Rabbit extends Animal {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    public Rabbit() {
        super("Rabbit", "\uD83D\uDC30",
                CONFIG.getWeight(Rabbit.class),
                CONFIG.getSpeed(Rabbit.class),
                CONFIG.getFoodQuantity(Rabbit.class));
    }
}
