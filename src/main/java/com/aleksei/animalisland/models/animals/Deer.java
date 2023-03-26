package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;
import com.aleksei.animalisland.repository.Herbivore;

public class Deer extends Animal {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Deer() {
        super("Deer", "\uD83E\uDD8C",
                CONFIG.getWeight(Deer.class),
                CONFIG.getSpeed(Deer.class),
                CONFIG.getFoodQuantity(Deer.class));
    }
}
