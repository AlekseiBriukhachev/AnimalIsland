package com.aleksei.animalisland.utils.factories;

import com.aleksei.animalisland.config.BaseConfig;
import com.aleksei.animalisland.models.animals.*;
import com.aleksei.animalisland.models.plant.Grass;
import com.aleksei.animalisland.utils.enumartion.AnimalType;
import com.aleksei.animalisland.utils.exceptions.UnknownAnimalException;

public class AnimalFactory<T extends EntityAI> {
    private static AnimalFactory instance;
    private AnimalFactory(){}
    public static synchronized AnimalFactory getInstance(){
        if (instance == null){
            instance = new AnimalFactory();
        }
        return instance;
    }
    public EntityAI create(AnimalType type) {
        return switch (type){
            case WOLF -> new Wolf();
            case SNAKE -> new Snake();
            case FOX -> new Fox();
            case BEAR -> new Bear();
            case EAGLE -> new Eagle();
            case HORSE -> new Horse();
            case DEER -> new Deer();
            case RABBIT -> new Rabbit();
            case MOUSE -> new Mouse();
            case GOAT -> new Goat();
            case SHEEP -> new Sheep();
            case BOAR -> new Boar();
            case BUFFALO -> new Buffalo();
            case DUCK -> new Duck();
            case CATERPILLAR -> new Caterpillar();
            case GRASS -> new Grass();
        };
    }
}
