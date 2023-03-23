package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.AppConfig;

public class Duck extends Animal {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    public Duck() {
        super("Duck", "\uD83E\uDD86",
                CONFIG.getWeight(Duck.class),
                CONFIG.getSpeed(Duck.class),
                CONFIG.getFoodQuantity(Duck.class));
    }
}
