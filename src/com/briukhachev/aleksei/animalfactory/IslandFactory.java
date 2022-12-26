package com.briukhachev.aleksei.animalfactory;

import com.briukhachev.aleksei.animalfactory.animals.*;

public class IslandFactory {
    private Params params = new Params();
    public Animal createNewOrganism(AnimalType type){
        return switch (type){
            case WOLF -> new Wolf(params.getAnimalWeight(Wolf.class), (int) params.getAnimalSpeed(Wolf.class), params.getAnimalFoodQuantity(Wolf.class));
            case SNAKE -> new Snake(params.getAnimalWeight(Snake.class), (int) params.getAnimalSpeed(Snake.class), params.getAnimalFoodQuantity(Snake.class));
            case FOX -> new Fox(params.getAnimalWeight(Fox.class), (int) params.getAnimalSpeed(Fox.class), params.getAnimalFoodQuantity(Fox.class));
            case BEAR -> new Bear(params.getAnimalWeight(Bear.class), (int) params.getAnimalSpeed(Bear.class), params.getAnimalFoodQuantity(Bear.class));
            case EAGLE -> new Eagle(params.getAnimalWeight(Eagle.class), (int) params.getAnimalSpeed(Eagle.class), params.getAnimalFoodQuantity(Eagle.class));
            case HORSE -> new Horse(params.getAnimalWeight(Horse.class), (int) params.getAnimalSpeed(Horse.class), params.getAnimalFoodQuantity(Horse.class));
            case DEER -> new Deer(params.getAnimalWeight(Deer.class), (int) params.getAnimalSpeed(Deer.class), params.getAnimalFoodQuantity(Deer.class));
            case RABBIT -> new Rabbit(params.getAnimalWeight(Rabbit.class), (int) params.getAnimalSpeed(Rabbit.class), params.getAnimalFoodQuantity(Rabbit.class));
            case MOUSE -> new Mouse(params.getAnimalWeight(Mouse.class), (int) params.getAnimalSpeed(Mouse.class), params.getAnimalFoodQuantity(Mouse.class));
            case GOAT -> new Goat(params.getAnimalWeight(Goat.class), (int) params.getAnimalSpeed(Goat.class), params.getAnimalFoodQuantity(Goat.class));
            case SHEEP -> new Sheep(params.getAnimalWeight(Sheep.class), (int) params.getAnimalSpeed(Sheep.class), params.getAnimalFoodQuantity(Sheep.class));
            case BOAR -> new Boar(params.getAnimalWeight(Boar.class), (int) params.getAnimalSpeed(Boar.class), params.getAnimalFoodQuantity(Boar.class));
            case BUFFALO -> new Buffalo(params.getAnimalWeight(Buffalo.class), (int) params.getAnimalSpeed(Buffalo.class), params.getAnimalFoodQuantity(Buffalo.class));
            case DUCK -> new Duck(params.getAnimalWeight(Duck.class), (int) params.getAnimalSpeed(Duck.class), params.getAnimalFoodQuantity(Duck.class));
            case CATERPILLAR -> new Caterpillar(params.getAnimalWeight(Caterpillar.class), (int) params.getAnimalSpeed(Caterpillar.class), params.getAnimalFoodQuantity(Caterpillar.class));
            case PLANT -> new Plants((int)params.getPlantWeight());
//            case EMPTY -> null;
        };
    }


}
