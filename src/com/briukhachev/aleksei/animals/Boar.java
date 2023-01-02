package com.briukhachev.aleksei.animals;

import com.briukhachev.aleksei.animalfactory.Animal;
import com.briukhachev.aleksei.animalfactory.Herbivores;
import com.briukhachev.aleksei.animalfactory.Predator;

import java.awt.*;

public class Boar extends Animal implements Predator, Herbivores {
    private static Image image;
    private static int count;

    public Boar(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
        image = Toolkit.getDefaultToolkit().getImage("res/Boar.png");
        count++;
    }

    public static Image getImage() {
        return image;
    }

    public static int getCount() {
        return count;
    }
}
