package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.config.BaseConfig;

public class Snake extends Animal implements Predator {
    private static final BaseConfig CONFIG = BaseConfig.getAppConfig();
    public Snake() {
        super("Snake", "\uD83D\uDC0D",
                CONFIG.getWeight(Snake.class),
                CONFIG.getSpeed(Snake.class),
                CONFIG.getFoodQuantity(Snake.class));
    }
}
