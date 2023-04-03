package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;

public class Boar extends Animal implements Herbivore, Predator {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Boar() {
        super("Boar", "\uD83D\uDC17",
                CONFIG.getWeight(Boar.class),
                CONFIG.getSpeed(Boar.class),
                CONFIG.getFoodQuantity(Boar.class));
    }
}
