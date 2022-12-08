package com.briukhachev.aleksei.animals;

import com.briukhachev.aleksei.animalplant.Animal;
import com.briukhachev.aleksei.animalplant.Predator;

import java.util.List;

public class Snake extends Predator {

    @Override
    public List<? extends Animal> createNew() {
        return null;
    }

    @Override
    public void move() {

    }
}
