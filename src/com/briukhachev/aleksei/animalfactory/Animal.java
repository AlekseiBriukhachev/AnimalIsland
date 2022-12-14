package com.briukhachev.aleksei.animalfactory;

public abstract class Animal extends Organism {
    private final int speed;
    private final double foodQuantity;

    public Animal(double weight, int speed, double foodQuantity) {
        super(weight);
        this.speed = speed;
        this.foodQuantity = foodQuantity;
    }

    public void move() {
        //TO DO
    }

    public void eat(){
        //TO DO
    }
}
