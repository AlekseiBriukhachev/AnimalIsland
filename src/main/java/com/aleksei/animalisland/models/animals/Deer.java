package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.AppConfig;

public class Deer extends Animal {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    public Deer() {
        super("Deer", "\uD83E\uDD8C",
                CONFIG.getWeight(Deer.class),
                CONFIG.getSpeed(Deer.class),
                CONFIG.getFoodQuantity(Deer.class));
    }
}
