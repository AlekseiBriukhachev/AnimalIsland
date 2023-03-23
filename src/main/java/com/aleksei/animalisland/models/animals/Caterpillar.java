package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.AppConfig;

public class Caterpillar extends Animal {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    public Caterpillar() {
        super("Caterpillar", "\uD83D\uDC1B",
                CONFIG.getWeight(Caterpillar.class),
                CONFIG.getSpeed(Caterpillar.class),
                CONFIG.getFoodQuantity(Caterpillar.class) );
    }
}
