package com.briukhachev.aleksei.animals;

import com.briukhachev.aleksei.animalfactory.Animal;
import com.briukhachev.aleksei.animalfactory.Predator;

import java.awt.*;

public class Bear extends Animal implements Predator {

    public Bear(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
        image = Toolkit.getDefaultToolkit().getImage("res/Bear.png");
        count++;
    }
}
