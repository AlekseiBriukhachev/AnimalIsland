package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;

public class Fox extends Animal implements Predator {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Fox() {
        super("Fox", "\uD83E\uDD8A",
                CONFIG.getWeight(Fox.class),
                CONFIG.getSpeed(Fox.class),
                CONFIG.getFoodQuantity(Fox.class));
    }
}
