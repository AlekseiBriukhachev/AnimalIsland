package com.briukhachev.aleksei.animalplant;


import java.util.List;

public abstract class Animal extends Organism {
    public abstract void eat(List<? extends Organism> organisms);
    public abstract List<? extends Animal> createNew();
    public abstract void move();
}
