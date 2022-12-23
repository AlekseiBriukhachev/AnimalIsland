package com.briukhachev.aleksei.animalfactory.animals;

import com.briukhachev.aleksei.animalfactory.Animal;
import com.briukhachev.aleksei.animalfactory.Herbivores;
import com.briukhachev.aleksei.animalfactory.Predator;

import java.awt.*;

public class Duck extends Animal implements Predator, Herbivores {
    private final double weight;
    private final int speed;
    private final double foodQuantity;
    public static Image image;
    public static int count;

    public Duck(double weight, int speed, double foodQuantity) {
        this.weight = weight;
        this.speed = speed;
        this.foodQuantity = foodQuantity;
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
