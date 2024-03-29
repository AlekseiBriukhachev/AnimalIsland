package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;

public class Wolf extends Animal implements Predator {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Wolf() {
        super("Wolf", "\uD83D\uDC3A",
                CONFIG.getWeight(Wolf.class),
                CONFIG.getSpeed(Wolf.class),
                CONFIG.getFoodQuantity(Wolf.class));
    }
}
