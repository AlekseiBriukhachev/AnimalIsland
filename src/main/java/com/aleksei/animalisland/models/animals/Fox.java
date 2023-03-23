package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.AppConfig;

public class Fox extends Animal {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    public Fox() {
        super("Fox", "\uD83E\uDD8A",
                CONFIG.getWeight(Fox.class),
                CONFIG.getSpeed(Fox.class),
                CONFIG.getFoodQuantity(Fox.class));
    }
}
