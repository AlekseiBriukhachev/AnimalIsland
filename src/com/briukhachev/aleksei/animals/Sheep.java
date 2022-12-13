package com.briukhachev.aleksei.animals;

import com.briukhachev.aleksei.Location;
import com.briukhachev.aleksei.service.Params;
import com.briukhachev.aleksei.animalplant.Herbivores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Sheep extends Herbivores {
    private double weight;
    private int speed;
    private double foodQuantity;
    private Params params = new Params();
    private List<Sheep> sheepList = new ArrayList<>();

    private Sheep(double weight, int speed, double foodQuantity){
        this.weight = weight;
        this.speed = speed;
        this.foodQuantity = foodQuantity;
    }

    @Override
    public List<Sheep> createNew() {
        if (sheepList.size() < params.getSheepCount()){
            sheepList.add(new Sheep(70, 3, 15));
            return sheepList;
        }
        return null;
    }

    @Override
    public void move() {
        for (Sheep sheep : sheepList) {
            int x = ThreadLocalRandom.current().nextInt(speed);
            int y = ThreadLocalRandom.current().nextInt(speed);
            sheep.setLocation(new Location());
        }

    }

    public List<Sheep> getSheepList() {
        return sheepList;
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
