package com.briukhachev.aleksei.animalplant;

public abstract class Herbivores extends Animal {

    public Herbivores(double weight, int speed, double foodQuantity, boolean isEatable) {
        super(weight, speed, foodQuantity, isEatable);
    }
    public void eat(Organism food) {
    }

    public void born(Animal child) {
    }

    public void move() {
    }

}
