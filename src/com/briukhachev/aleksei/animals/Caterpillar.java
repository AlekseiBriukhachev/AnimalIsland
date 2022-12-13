package com.briukhachev.aleksei.animals;

import com.briukhachev.aleksei.Location;
import com.briukhachev.aleksei.service.Params;
import com.briukhachev.aleksei.animalplant.Herbivores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Caterpillar extends Herbivores {

    private double weight;
    private int speed;
    private double foodQuantity;
    private Params params = new Params();
    private List<Caterpillar> caterpillarList = new ArrayList<>();

    private Caterpillar(double weight, int speed, double foodQuantity){
        this.weight = weight;
        this.speed = speed;
        this.foodQuantity = foodQuantity;
    }

    @Override
    public List<Caterpillar> createNew() {
        if (caterpillarList.size() < params.getCaterpillarCount()){
            caterpillarList.add(new Caterpillar(0.01d, 0, 0));
            return caterpillarList;
        }
        return null;
    }

    @Override
    public void move() {
        for (Caterpillar caterpillar : caterpillarList) {
            int x = ThreadLocalRandom.current().nextInt(speed);
            int y = ThreadLocalRandom.current().nextInt(speed);
            caterpillar.setLocation(new Location());
        }

    }

    public List<Caterpillar> getCaterpillarList() {
        return caterpillarList;
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
