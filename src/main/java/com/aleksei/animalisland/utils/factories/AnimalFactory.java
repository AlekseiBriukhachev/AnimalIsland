package com.aleksei.animalisland.utils.factories;

import com.aleksei.animalisland.config.AppConfig;
import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.*;
import com.aleksei.animalisland.utils.enumartion.AnimalType;
import com.aleksei.animalisland.utils.exceptions.UnknownAnimalException;

public class AnimalFactory<T extends Animal> {
    private final AppConfig configFactory = AppConfig.getAppConfig();
    private static AnimalFactory instance;
    private AnimalFactory(){}
    public static synchronized AnimalFactory getInstance(){
        if (instance == null){
            instance = new AnimalFactory();
        }
        return instance;
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
            default -> throw new UnknownAnimalException("Unexpected value: " + type);
        };
    }
}
