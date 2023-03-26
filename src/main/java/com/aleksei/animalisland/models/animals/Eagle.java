package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;
import com.aleksei.animalisland.repository.Predator;

public class Eagle extends Animal {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Eagle() {
        super("Eagle", "\uD83E\uDD85",
                CONFIG.getWeight(Eagle.class),
                CONFIG.getSpeed(Eagle.class),
                CONFIG.getFoodQuantity(Eagle.class),
                CONFIG.getEatingProbability(Eagle.class));
    }
}
