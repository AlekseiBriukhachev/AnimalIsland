package com.briukhachev.aleksei.animals;

import com.briukhachev.aleksei.Location;
import com.briukhachev.aleksei.service.Params;
import com.briukhachev.aleksei.animalplant.Animal;
import com.briukhachev.aleksei.animalplant.Predator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Bear extends Predator {
    private double weight;
    private int speed;
    private double foodQuantity;
    private Params params = new Params();
    private List<Bear> bears = new ArrayList<>();

    private Bear(double weight, int speed, double foodQuantity) {
        this.weight = weight;
        this.speed = speed;
        this.foodQuantity = foodQuantity;
    }

    @Override
    public List<? extends Animal> createNew() {
        if (bears.size() < params.getBearCount()) {
            bears.add(new Bear(500, 2, 80));
            return bears;
        }
        return null;
    }

    @Override
    public void move() {
        for (Bear bear : bears) {
            int x = ThreadLocalRandom.current().nextInt(speed);
            int y = ThreadLocalRandom.current().nextInt(speed);
            bear.setLocation(new Location(x, y));
        }

    }

    public List<Bear> getBears() {
        return bears;
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
