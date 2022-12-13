package com.briukhachev.aleksei.animals;

import com.briukhachev.aleksei.Location;
import com.briukhachev.aleksei.service.Params;
import com.briukhachev.aleksei.animalplant.Predator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Eagle extends Predator {
    private double weight;
    private int speed;
    private double foodQuantity;
    private Params params = new Params();
    private List<Eagle> eagles = new ArrayList<>();

    private Eagle(double weight, int speed, double foodQuantity){
        this.weight = weight;
        this.speed = speed;
        this.foodQuantity = foodQuantity;
    }

    @Override
    public List<Eagle> createNew() {
        if (eagles.size() < params.getEagleCount()){
            eagles.add(new Eagle(6, 3, 1));
            return eagles;
        }
        return null;
    }

    @Override
    public void move() {
        for (Eagle eagle : eagles) {
            int x = ThreadLocalRandom.current().nextInt(speed);
            int y = ThreadLocalRandom.current().nextInt(speed);
            eagle.setLocation(new Location());
        }

    }

    public List<Eagle> getEagles() {
        return eagles;
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
