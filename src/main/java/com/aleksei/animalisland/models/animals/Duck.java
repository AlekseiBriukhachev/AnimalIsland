package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;
import com.aleksei.animalisland.repository.Herbivore;
import com.aleksei.animalisland.repository.Predator;

public class Duck extends Animal {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Duck() {
        super("Duck", "\uD83E\uDD86",
                CONFIG.getWeight(Duck.class),
                CONFIG.getSpeed(Duck.class),
                CONFIG.getFoodQuantity(Duck.class),
                CONFIG.getEatingProbability(Duck.class));
    }
}
