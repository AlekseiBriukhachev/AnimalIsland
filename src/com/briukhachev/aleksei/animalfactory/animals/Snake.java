package com.briukhachev.aleksei.animalfactory.animals;

import com.briukhachev.aleksei.animalfactory.Animal;
import com.briukhachev.aleksei.animalfactory.Predator;

public class Snake extends Animal implements Predator {

    public Snake(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
    }

    @Override
    public void eatMeat() {

    }
}
