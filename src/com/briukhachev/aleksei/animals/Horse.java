package com.briukhachev.aleksei.animals;

import com.briukhachev.aleksei.Location;
import com.briukhachev.aleksei.Params;
import com.briukhachev.aleksei.animalplant.Herbivores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Horse extends Herbivores {
    private double weight;
    private int speed;
    private double foodQuantity;
    private Params params = new Params();
    private List<Horse> horses = new ArrayList<>();

    private Horse(double weight, int speed, double foodQuantity){
        this.weight = weight;
        this.speed = speed;
        this.foodQuantity = foodQuantity;
    }

    @Override
    public List<Horse> createNew() {
        if (horses.size() < params.getHorseCount()){
            horses.add(new Horse(400, 20, 60));
            return horses;
        }
        return null;
    }

    @Override
    public void move() {
        for (Horse horse : horses) {
            int x = ThreadLocalRandom.current().nextInt(speed);
            int y = ThreadLocalRandom.current().nextInt(speed);
            horse.setLocation(new Location());
        }

    }

    public List<Horse> getHorses() {
        return horses;
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
}
