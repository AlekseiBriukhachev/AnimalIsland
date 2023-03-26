package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;
import com.aleksei.animalisland.repository.Predator;

public class Fox extends Animal{
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Fox() {
        super("Fox", "\uD83E\uDD8A",
                CONFIG.getWeight(Fox.class),
                CONFIG.getSpeed(Fox.class),
                CONFIG.getFoodQuantity(Fox.class),
                CONFIG.getEatingProbability(Fox.class));
    }
}
