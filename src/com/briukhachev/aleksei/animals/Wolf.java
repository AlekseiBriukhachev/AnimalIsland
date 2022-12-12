package com.briukhachev.aleksei.animals;

import com.briukhachev.aleksei.Location;
import com.briukhachev.aleksei.Params;
import com.briukhachev.aleksei.animalplant.Animal;
import com.briukhachev.aleksei.animalplant.Predator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Wolf extends Predator {
    private double weight;
    private int speed;
    private double foodQuantity;
    private Params params = new Params();
    private List<Wolf> wolfList = new ArrayList<>();

    private Wolf(double weight, int speed, double foodQuantity){
        this.weight = weight;
        this.speed = speed;
        this.foodQuantity = foodQuantity;
    }

    @Override
    public List<Wolf> createNew() {
        if (wolfList.size() < params.getWolfCount()){
            wolfList.add(new Wolf(50, 3, 8));
            return wolfList;
        }
        return null;
    }

    @Override
    public void move() {
        for (Wolf wolf : wolfList) {
            int x = ThreadLocalRandom.current().nextInt(speed);
            int y = ThreadLocalRandom.current().nextInt(speed);
            wolf.setLocation(new Location());
        }

    }

    public List<Wolf> getWolfList() {
        return wolfList;
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
