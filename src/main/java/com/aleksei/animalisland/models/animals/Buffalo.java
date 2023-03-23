package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.AppConfig;

public class Buffalo extends Animal {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    public Buffalo() {
        super("Buffalo", "\uD83D\uDC03",
                CONFIG.getWeight(Buffalo.class),
                CONFIG.getSpeed(Buffalo.class),
                CONFIG.getFoodQuantity(Buffalo.class));
    }
}
