package com.briukhachev.aleksei.animalfactory.animals;

import com.briukhachev.aleksei.animalfactory.Animal;
import com.briukhachev.aleksei.animalfactory.Herbivores;

import java.awt.*;

public class Buffalo extends Animal implements Herbivores {

    private final double weight;
    private final int speed;
    private final double foodQuantity;
    public static Image image;
    public static int count;

    public Buffalo(double weight, int speed, double foodQuantity) {
        this.weight = weight;
        this.speed = speed;
        this.foodQuantity = foodQuantity;
        image = Toolkit.getDefaultToolkit().getImage("res/Buffalo.png");
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