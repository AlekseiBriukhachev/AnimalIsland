package com.aleksei.animalisland.utils.factory;

import com.aleksei.animalisland.config.AppConfig;
import com.aleksei.animalisland.models.Plant;
import com.typesafe.config.Config;

public class GrassFactory {

    protected static final Config CONF = AppConfig.ROOT.getConfig("grass");

    private static final int FOOD_VALUE = CONF.getInt("foodValue");
    private static final int MAX = CONF.getInt("max");
    private static final int INCREASE_RATE = CONF.getInt("increaseRate");

    public Plant createGrass() {
        return new Plant(FOOD_VALUE, MAX, INCREASE_RATE);
    }
}
