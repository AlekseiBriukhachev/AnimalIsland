package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;

public class Buffalo extends Animal implements Herbivore {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Buffalo() {
        super("Buffalo", "\uD83D\uDC03",
                CONFIG.getWeight(Buffalo.class),
                CONFIG.getSpeed(Buffalo.class),
                CONFIG.getFoodQuantity(Buffalo.class));
    }
}
