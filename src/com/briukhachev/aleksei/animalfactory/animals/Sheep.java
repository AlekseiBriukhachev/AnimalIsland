package com.briukhachev.aleksei.animalfactory.animals;

import com.briukhachev.aleksei.animalfactory.Animal;
import com.briukhachev.aleksei.animalfactory.Herbivores;

public class Sheep extends Animal implements Herbivores {

    public Sheep(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }

    @Override
    public void eatPlants() {

    }
}
