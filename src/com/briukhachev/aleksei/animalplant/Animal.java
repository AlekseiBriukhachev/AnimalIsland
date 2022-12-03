package com.briukhachev.aleksei.animalplant;


public abstract class Animal extends Organism {


    public Animal(double weight, int speed, double foodQuantity, boolean isEatable) {
        super(weight, speed, foodQuantity, isEatable);
    }

    public boolean eat(Organism organism) {
        return false;
    }

    public void born(Animal child) {
    }

    public void move() {
    }
}
