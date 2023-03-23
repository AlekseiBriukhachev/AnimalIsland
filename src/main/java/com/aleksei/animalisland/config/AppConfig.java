package com.aleksei.animalisland.config;


import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.EntityAI;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.PropertyConfigurator;

import java.util.Arrays;

@Slf4j
public final class AppConfig {
    private Config config;
    private static AppConfig appConfig;
    private static void init() {
        PropertyConfigurator.configure("log4j.properties");
    }

    private AppConfig(Config config) {
        log.debug("Create configuration");
        this.config = config;
        config.checkValid(ConfigFactory.defaultReference(), "island-simulation");
//        init();

    }

    private AppConfig() {
        this(ConfigFactory.load());
        log.debug("Load configuration file");

    }
    public static AppConfig getAppConfig(){
        if (appConfig == null){
            appConfig = new AppConfig();
        }
        return appConfig;
    }

    public double getWeight(Class<? extends Animal> aClass) {
        return config.getDouble(aClass.getSimpleName().toLowerCase() + ".weight");
    }
    public int getMaxNumberPerLocation(String animal) {
        return config.getInt( animal+ ".maxNumberPerLocation");
    }
    public int getSpeed(Class<? extends Animal> aClass) {
        return config.getInt(aClass.getSimpleName().toLowerCase() + ".speed");
    }
    public double getFoodQuantity(Class<? extends Animal> aClass) {
        return config.getDouble(aClass.getSimpleName().toLowerCase() + ".foodAmount");
    }
    public int getInitNumber(Class<? extends Animal> aClass){
        return config.getInt(aClass.getSimpleName().toLowerCase() + ".initNumber");
    }
    public int[] getEatingProbability(Class<? extends EntityAI> aClass){

        String strEatProbability = config.getString(aClass.getSimpleName().toLowerCase() + ".eatProbability");
        String[] splitStr = strEatProbability.split(", ");

        return Arrays.stream(splitStr).mapToInt(Integer::parseInt).toArray();
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
    public String getGrasColor(){
        return config.getString("grass.color");
    }
}
