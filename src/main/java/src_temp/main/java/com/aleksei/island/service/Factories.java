package src_temp.main.java.com.aleksei.island.service;

import com.aleksei.island.config.AppConfig;
import com.aleksei.island.entities.*;
import com.aleksei.island.enumartion.AnimalType;

import java.awt.*;

public class Factories {
    private final AppConfig configFactory = AppConfig.getAppConfig();
    public Image chooseImage(AnimalType type) {

        return switch (type) {
            case BEAR -> Toolkit.getDefaultToolkit().getImage("images/Bear.png");
            case BOAR -> Toolkit.getDefaultToolkit().getImage("images/Boar.png");
            case BUFFALO -> Toolkit.getDefaultToolkit().getImage("images/Buffalo.png");
            case CATERPILLAR -> Toolkit.getDefaultToolkit().getImage("images/Caterpillar.png");
            case DEER -> Toolkit.getDefaultToolkit().getImage("images/Deer.png");
            case DUCK -> Toolkit.getDefaultToolkit().getImage("images/Duck.png");
            case EAGLE -> Toolkit.getDefaultToolkit().getImage("images/Eagle.png");
            case FOX -> Toolkit.getDefaultToolkit().getImage("images/Fox.png");
            case GOAT -> Toolkit.getDefaultToolkit().getImage("images/Goat.png");
            case HORSE -> Toolkit.getDefaultToolkit().getImage("images/Horse.png");
            case MOUSE -> Toolkit.getDefaultToolkit().getImage("images/Mouse.png");
            case RABBIT -> Toolkit.getDefaultToolkit().getImage("images/Rabbit.png");
            case SHEEP -> Toolkit.getDefaultToolkit().getImage("images/Sheep.png");
            case SNAKE -> Toolkit.getDefaultToolkit().getImage("images/Snake.png");
            case WOLF -> Toolkit.getDefaultToolkit().getImage("images/Wolf.png");
        };
    }
    public Animal create(AnimalType type) {
        return switch (type){
            case WOLF -> new Wolf((int) configFactory.getWeight(type), configFactory.getSpeed(type), (int) configFactory.getFoodQuantity(type));
            case SNAKE -> new Snake((int) configFactory.getWeight(type), configFactory.getSpeed(type), (int) configFactory.getFoodQuantity(type));
            case FOX -> new Fox((int) configFactory.getWeight(type), configFactory.getSpeed(type), (int) configFactory.getFoodQuantity(type));
            case BEAR -> new Bear((int) configFactory.getWeight(type), configFactory.getSpeed(type), (int) configFactory.getFoodQuantity(type));
            case EAGLE -> new Eagle((int) configFactory.getWeight(type), configFactory.getSpeed(type), (int) configFactory.getFoodQuantity(type));
            case HORSE -> new Horse((int) configFactory.getWeight(type), configFactory.getSpeed(type), (int) configFactory.getFoodQuantity(type));
            case DEER -> new Deer((int) configFactory.getWeight(type), configFactory.getSpeed(type), (int) configFactory.getFoodQuantity(type));
            case RABBIT -> new Rabbit((int) configFactory.getWeight(type), configFactory.getSpeed(type), configFactory.getFoodQuantity(type));
            case MOUSE -> new Mouse(configFactory.getWeight(type), configFactory.getSpeed(type), configFactory.getFoodQuantity(type));
            case GOAT -> new Goat((int) configFactory.getWeight(type), configFactory.getSpeed(type), (int) configFactory.getFoodQuantity(type));
            case SHEEP -> new Sheep((int) configFactory.getWeight(type), configFactory.getSpeed(type), (int) configFactory.getFoodQuantity(type));
            case BOAR -> new Boar((int) configFactory.getWeight(type), configFactory.getSpeed(type), (int) configFactory.getFoodQuantity(type));
            case BUFFALO -> new Buffalo((int) configFactory.getWeight(type), configFactory.getSpeed(type), (int) configFactory.getFoodQuantity(type));
            case DUCK -> new Duck((int) configFactory.getWeight(type), configFactory.getSpeed(type), configFactory.getFoodQuantity(type));
            case CATERPILLAR -> new Caterpillar(configFactory.getWeight(type), configFactory.getSpeed(type), (int) configFactory.getFoodQuantity(type));
        };
    }
}
