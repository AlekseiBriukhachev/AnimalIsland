package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;
import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.Predator;

public class Bear extends Animal implements Predator {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Bear() {
        super("Bear", "\uD83D\uDC3B",
                CONFIG.getWeight(Bear.class),
                CONFIG.getSpeed(Bear.class),
                CONFIG.getFoodQuantity(Bear.class));
    }

}
