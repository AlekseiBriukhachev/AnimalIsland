package com.briukhachev.aleksei.animals;

import com.briukhachev.aleksei.Location;
import com.briukhachev.aleksei.service.Params;
import com.briukhachev.aleksei.animalplant.Herbivores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Goat extends Herbivores {
    private double weight;
    private int speed;
    private double foodQuantity;
    private Params params = new Params();
    private List<Goat> goatList = new ArrayList<>();

    private Goat(double weight, int speed, double foodQuantity){
        this.weight = weight;
        this.speed = speed;
        this.foodQuantity = foodQuantity;
    }

    @Override
    public List<Goat> createNew() {
        if (goatList.size() < params.getGoatCount()){
            goatList.add(new Goat(60, 3, 10));
            return goatList;
        }
        return null;
    }

    @Override
    public void move() {
        for (Goat goat : goatList) {
            int x = ThreadLocalRandom.current().nextInt(speed);
            int y = ThreadLocalRandom.current().nextInt(speed);
            goat.setLocation(new Location());
        }

    }

    public List<Goat> getGoatList() {
        return goatList;
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
