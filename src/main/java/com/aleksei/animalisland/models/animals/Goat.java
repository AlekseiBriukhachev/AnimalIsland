package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;

public class Goat extends Animal implements Herbivore {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Goat() {
        super("Goat", "\uD83D\uDC10",
                CONFIG.getWeight(Goat.class),
                CONFIG.getSpeed(Goat.class),
                CONFIG.getFoodQuantity(Goat.class));
    }
}
