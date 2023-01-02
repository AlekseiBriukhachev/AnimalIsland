package com.briukhachev.aleksei.animals;

import com.briukhachev.aleksei.animalfactory.Animal;
import com.briukhachev.aleksei.animalfactory.Herbivores;

import java.awt.*;

public class Deer extends Animal implements Herbivores {

    private static Image image;
    private static int count;

    public Deer(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
        image = Toolkit.getDefaultToolkit().getImage("res/Deer.png");
        count++;
    }

    public static Image getImage() {
        return image;
    }

    public static int getCount() {
        return count;
    }
}

