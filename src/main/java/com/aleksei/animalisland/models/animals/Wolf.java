package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.AppConfig;

public class Wolf extends Animal {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    public Wolf() {
        super("Wolf", "\uD83D\uDC3A",
                CONFIG.getWeight(Wolf.class),
                CONFIG.getSpeed(Wolf.class),
                CONFIG.getFoodQuantity(Wolf.class));
    }
}
