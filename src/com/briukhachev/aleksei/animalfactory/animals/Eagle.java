package com.briukhachev.aleksei.animalfactory.animals;

import com.briukhachev.aleksei.animalfactory.Animal;
import com.briukhachev.aleksei.animalfactory.Predator;

import java.awt.*;

public class Eagle extends Animal implements Predator {

    private final double weight;
    private final int speed;
    private final double foodQuantity;
    public static Image image;
    public static int count;

    public Eagle(double weight, int speed, double foodQuantity) {
        this.weight = weight;
        this.speed = speed;
        this.foodQuantity = foodQuantity;
        image = Toolkit.getDefaultToolkit().getImage("res/Eagle.png");
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