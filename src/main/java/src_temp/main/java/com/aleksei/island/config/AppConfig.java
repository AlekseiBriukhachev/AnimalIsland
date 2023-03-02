package src_temp.main.java.com.aleksei.island.config;

import com.aleksei.island.entities.Animal;
import com.aleksei.island.enumartion.AnimalType;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public final class AppConfig {
    private Config config;
    private static AppConfig appConfig;
    private static final Logger log = Logger.getLogger(AppConfig.class);
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
