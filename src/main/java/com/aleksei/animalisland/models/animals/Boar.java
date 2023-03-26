package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;
import com.aleksei.animalisland.repository.Herbivore;
import com.aleksei.animalisland.repository.Predator;

public class Boar extends Animal {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Boar() {
        super("Boar", "\uD83D\uDC17",
                CONFIG.getWeight(Boar.class),
                CONFIG.getSpeed(Boar.class),
                CONFIG.getFoodQuantity(Boar.class));
    }
}
