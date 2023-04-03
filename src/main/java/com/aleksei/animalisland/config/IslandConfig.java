package com.aleksei.animalisland.config;


public class IslandConfig {
    private final BaseConfig CONFIG = BaseConfig.getAppConfig();

    public int getIslandSizeByX() {
        return CONFIG.getIslandX();
    }

    public int getIslandSizeByY() {
        return CONFIG.getIslandY();
    }
}
