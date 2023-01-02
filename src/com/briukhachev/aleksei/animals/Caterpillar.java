package com.briukhachev.aleksei.animals;

import com.briukhachev.aleksei.animalfactory.Animal;
import com.briukhachev.aleksei.animalfactory.Herbivores;

import java.awt.*;

public class Caterpillar extends Animal implements Herbivores {

    private static Image image;
    private static int count;

    public Caterpillar(double weight, int speed, double foodQuantity) {
        super(weight, speed, foodQuantity);
        image = Toolkit.getDefaultToolkit().getImage("res/Caterpillar.png");
        count++;
    }

    public static Image getImage() {
        return image;
    }

    public static int getCount() {
        return count;
    }
}
