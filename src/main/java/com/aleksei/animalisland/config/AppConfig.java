package com.aleksei.animalisland.config;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.PropertyConfigurator;

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

    }

    private AppConfig() {
        this(ConfigFactory.load());
        log.debug("Load configuration file");

    }

    public static AppConfig getAppConfig() {
        if (appConfig == null) {
            appConfig = new AppConfig();
        }
        return appConfig;
    }
    public int getIslandWidth() {
        return config.getInt("island.width");
    }

    public int getIslandHeight() {
        return config.getInt("island.height");
    }

    public int getIslandX() {
        return config.getInt("island.x");
    }

    public int getIslandY() {
        return config.getInt("island.y");
    }
}
