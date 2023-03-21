package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;

public class Mouse extends Animal implements Herbivore, Predator {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Mouse() {
        super("Mouse", "\uD83D\uDC01",
                CONFIG.getWeight(Mouse.class),
                CONFIG.getSpeed(Mouse.class),
                CONFIG.getFoodQuantity(Mouse.class));
    }
}
