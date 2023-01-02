package com.briukhachev.aleksei.animals;

import com.briukhachev.aleksei.animalfactory.Animal;
import com.briukhachev.aleksei.animalfactory.Herbivores;
import com.briukhachev.aleksei.animalfactory.Predator;

import java.awt.*;

public class Duck extends Animal implements Predator, Herbivores {
    private static Image image;
    private static int count;

    public Duck(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
        image = Toolkit.getDefaultToolkit().getImage("res/Duck.png");
        count++;
    }

    public double getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }

    public double getFoodQuantity() {
        return foodQuantity;
    }
}
