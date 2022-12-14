package com.briukhachev.aleksei.animalfactory.animals;

import com.briukhachev.aleksei.animalfactory.Animal;
import com.briukhachev.aleksei.animalfactory.Herbivores;
import com.briukhachev.aleksei.animalfactory.Predator;

public class Mouse extends Animal implements Predator, Herbivores {

    public Mouse(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }

    @Override
    public void eatPlants() {

    }

    @Override
    public void eatMeat() {

    }
}
