package com.briukhachev.aleksei.animalfactory;

import com.briukhachev.aleksei.Location;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Organism {
    private int gender;

    public Animal(Location location) {
        super(location);
        gender = ThreadLocalRandom.current().nextInt(2);
    }

    public void move() {
        //TODO
    }

}
