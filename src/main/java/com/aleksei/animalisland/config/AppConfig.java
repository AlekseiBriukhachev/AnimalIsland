package com.aleksei.animalisland.config;


import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.utils.enumartion.AnimalType;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.List;

@Slf4j
public final class AppConfig {
    private Config config;
    private static AppConfig appConfig;
    private static void init() {
        PropertyConfigurator.configure("log4j.properties");
    }

    private AppConfig(Config config) {
        this.config = config;
        config.checkValid(ConfigFactory.defaultReference(), "island-simulation");
        log.info("Create configuration");

    }

    private AppConfig() {
        this(ConfigFactory.load());
        log.info("Load configuration file");

    }
    public static AppConfig getAppConfig(){
        if (appConfig == null){
            appConfig = new AppConfig();
        }
        return appConfig;
    }

    public double getWeight(AnimalType type) {
        return config.getDouble(type.name().toLowerCase() + ".weight");
    }
    public int getMaxNumberPerLocation(AnimalType type) {
        return config.getInt(type.name().toLowerCase() + ".maxNumberPerLocation");
    }
    public int getSpeed(AnimalType type) {
        return config.getInt(type.name().toLowerCase() + ".speed");
    }
    public double getFoodQuantity(AnimalType type) {
        return config.getDouble(type.name().toLowerCase() + ".foodQuantity");
    }
    public int getInitNumber(Class<? extends Animal> aClass){
        return config.getInt(aClass.getSimpleName().toLowerCase() + ".initNumber");
    }
    public List<String> getEatingProbability(Class<? extends Animal> aClass){

        return config.getStringList(aClass.getSimpleName().toLowerCase() + ".eatProbability");
    }

    public int getLocationSize() {
        return config.getInt("location.size");
    }

    public int getIslandWidth() {
        return config.getInt("island.width");
    }

    public int getIslandHeight() {
        return config.getInt("island.height");
    }
}
