package com.aleksei.animalisland.utils;

import com.aleksei.animalisland.simulation.animals.Animal;
import com.aleksei.animalisland.simulation.animals.*;
import com.aleksei.animalisland.utils.enums.AnimalType;


public class AnimalFactory {
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
        };
    }
}
