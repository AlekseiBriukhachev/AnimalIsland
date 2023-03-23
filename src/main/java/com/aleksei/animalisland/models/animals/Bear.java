package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.AppConfig;

public class Bear extends Animal {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    public Bear() {
        super("Bear", "\uD83D\uDC3B",
                CONFIG.getWeight(Bear.class),
                CONFIG.getSpeed(Bear.class),
                CONFIG.getFoodQuantity(Bear.class));
    }

}
