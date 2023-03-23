package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.AppConfig;

public class Eagle extends Animal {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    public Eagle() {
        super("Eagle", "\uD83E\uDD85",
                CONFIG.getWeight(Eagle.class),
                CONFIG.getSpeed(Eagle.class),
                CONFIG.getFoodQuantity(Eagle.class));
    }
}
