package com.briukhachev.aleksei.animalfactory;

import com.briukhachev.aleksei.animalfactory.animals.*;

public class IslandFactory {
    public Organism createNewOrganism(OrganismType type){
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
            case PLANT -> new Plants();
            case EMPTY -> null;
        };
    }
}
