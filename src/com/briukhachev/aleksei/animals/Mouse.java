package com.briukhachev.aleksei.animals;

import com.briukhachev.aleksei.animalplant.Animal;
import com.briukhachev.aleksei.animalplant.Herbivores;

import java.util.List;

public class Mouse extends Herbivores {
    @Override
    public List<? extends Animal> createNew() {
        return null;
    }

    @Override
    public void move() {

    }
}
