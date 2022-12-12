package com.briukhachev.aleksei.animals;

import com.briukhachev.aleksei.animalplant.Herbivores;

import com.briukhachev.aleksei.Location;
import com.briukhachev.aleksei.Params;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Rabbit extends Herbivores {
    private double weight;
    private int speed;
    private double foodQuantity;
    private Params params = new Params();
    private List<Rabbit> rabbits = new ArrayList<>();

    private Rabbit(double weight, int speed, double foodQuantity){
        this.weight = weight;
        this.speed = speed;
        this.foodQuantity = foodQuantity;
    }

    @Override
    public List<Rabbit> createNew() {
        if (rabbits.size() < params.getRabbitCount()){
            rabbits.add(new Rabbit(2, 2, 0.45d));
            return rabbits;
        }
        return null;
    }

    @Override
    public void move() {
        for (Rabbit duck : rabbits) {
            int x = ThreadLocalRandom.current().nextInt(speed);
            int y = ThreadLocalRandom.current().nextInt(speed);
            duck.setLocation(new Location());
        }

    }

    public List<Rabbit> getRabbits() {
        return rabbits;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(double foodQuantity) {
        this.foodQuantity = foodQuantity;
    }
    public void lifeCycle() {
        createNew();
        move();
//            eat();
    }
}

