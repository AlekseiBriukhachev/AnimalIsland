package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;

public class Caterpillar extends Animal implements Herbivore {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Caterpillar() {
        super("Caterpillar", "\uD83D\uDC1B",
                CONFIG.getWeight(Caterpillar.class),
                CONFIG.getSpeed(Caterpillar.class),
                CONFIG.getFoodQuantity(Caterpillar.class) );
    }
}
