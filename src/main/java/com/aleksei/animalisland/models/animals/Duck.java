package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;

public class Duck extends Animal implements Herbivore, Predator {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Duck() {
        super("Duck", "\uD83E\uDD86",
                CONFIG.getWeight(Duck.class),
                CONFIG.getSpeed(Duck.class),
                CONFIG.getFoodQuantity(Duck.class));
    }
}
