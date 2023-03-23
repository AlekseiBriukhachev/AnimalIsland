package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.AppConfig;

public class Mouse extends Animal {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    public Mouse() {
        super("Mouse", "\uD83D\uDC01",
                CONFIG.getWeight(Mouse.class),
                CONFIG.getSpeed(Mouse.class),
                CONFIG.getFoodQuantity(Mouse.class));
    }
}
