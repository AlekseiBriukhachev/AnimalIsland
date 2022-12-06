package com.briukhachev.aleksei.animals;

import com.briukhachev.aleksei.animalplant.Herbivores;
import com.briukhachev.aleksei.Location;
import com.briukhachev.aleksei.Params;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Deer extends Herbivores {
    private double weight;
    private int speed;
    private double foodQuantity;
    private Params params = new Params();
    private List<Deer> deerList = new ArrayList<>();

    private Deer(double weight, int speed, double foodQuantity) {
        this.weight = weight;
        this.speed = speed;
        this.foodQuantity = foodQuantity;
    }

    @Override
    public List<Deer> createNew() {
        if (deerList.size() < params.getDeerCount()) {
            deerList.add(new Deer(300, 20, 50));
            return deerList;
        }
        return null;
    }

    @Override
    public void move() {
        for (Deer deer : deerList) {
            int x = ThreadLocalRandom.current().nextInt(speed);
            int y = ThreadLocalRandom.current().nextInt(speed);
            deer.setLocation(new Location(x, y));
        }

    }

    public List<Deer> getDeerList() {
        return deerList;
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

