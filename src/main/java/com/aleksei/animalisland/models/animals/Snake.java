package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.AppConfig;

public class Snake extends Animal {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    public Snake() {
        super("Snake", "\uD83D\uDC0D",
                CONFIG.getWeight(Snake.class),
                CONFIG.getSpeed(Snake.class),
                CONFIG.getFoodQuantity(Snake.class));
    }
}
