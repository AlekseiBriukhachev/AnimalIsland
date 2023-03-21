package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;

public class Rabbit extends Animal implements Herbivore {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Rabbit() {
        super("Rabbit", "\uD83D\uDC30",
                CONFIG.getWeight(Rabbit.class),
                CONFIG.getSpeed(Rabbit.class),
                CONFIG.getFoodQuantity(Rabbit.class));
    }
}
