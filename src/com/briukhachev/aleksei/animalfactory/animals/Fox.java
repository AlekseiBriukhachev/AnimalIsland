package com.briukhachev.aleksei.animalfactory.animals;

import com.briukhachev.aleksei.animalfactory.Animal;
import com.briukhachev.aleksei.animalfactory.Predator;

public class Fox extends Animal implements Predator {

    public Fox(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }

    @Override
    public void eatMeat() {

    }
}
