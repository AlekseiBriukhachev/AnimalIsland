package com.aleksei.animalisland.config;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public final class AppConfig {
    private final Config config;
    private static AppConfig appConfig;
    @Getter
    private static final List<String> entityList = new ArrayList<>(List.of("bear", "rabbit", "grass"));

    private static void init() {
        PropertyConfigurator.configure("log4j.properties");
    }

    private AppConfig(Config config) {
        log.debug("Create configuration");
        this.config = config;
        config.checkValid(ConfigFactory.defaultReference(), "island-simulation");

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

    public double getWeight(String animal) {
        return config.getDouble(animal.toLowerCase() + ".weight");
    }
    public int getMaxNumberPerLocation(String animal) {
        return config.getInt( animal+ ".maxNumberPerLocation");
    }
    public int getSpeed(String animal) {
        return config.getInt(animal.toLowerCase() + ".speed");
    }
    public double getFoodQuantity(String animal) {
        return config.getDouble(animal.toLowerCase() + ".foodAmount");
    }
    public int getInitNumber(String animal){
        return config.getInt(animal.toLowerCase() + ".initNumber");
    }
    public Map<String, Integer> getEatingProbability(String animal){

        String strEatProbability = config.getString(animal.toLowerCase() + ".eatProbability");
        String[] splitStr = strEatProbability.split(", ");

        int[] eatingProbability = Arrays.stream(splitStr).mapToInt(Integer::parseInt).toArray();
        return IntStream.range(0, entityList.size())
                .boxed()
                .collect(Collectors.toMap(entityList::get, i -> eatingProbability[i], (a, b) -> b));

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
