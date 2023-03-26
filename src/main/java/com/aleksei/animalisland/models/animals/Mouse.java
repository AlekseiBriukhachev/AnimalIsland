package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;
import com.aleksei.animalisland.repository.Herbivore;
import com.aleksei.animalisland.repository.Predator;

public class Mouse extends Animal {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Mouse() {
        super("Mouse", "\uD83D\uDC01",
                CONFIG.getWeight(Mouse.class),
                CONFIG.getSpeed(Mouse.class),
                CONFIG.getFoodQuantity(Mouse.class),
                CONFIG.getEatingProbability(Mouse.class));
    }
}
