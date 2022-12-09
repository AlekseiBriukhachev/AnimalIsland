package com.briukhachev.aleksei.animals;

import com.briukhachev.aleksei.Location;
import com.briukhachev.aleksei.Params;
import com.briukhachev.aleksei.animalplant.Animal;
import com.briukhachev.aleksei.animalplant.Herbivores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Boar extends Herbivores {
    private double weight;
    private int speed;
    private double foodQuantity;
    private Params params = new Params();
    private List<Boar> boars = new ArrayList<>();

    private Boar(double weight, int speed, double foodQuantity){
        this.weight = weight;
        this.speed = speed;
        this.foodQuantity = foodQuantity;
    }

    @Override
    public List<Boar> createNew() {
        if (boars.size() < params.getDuckCount()){
            boars.add(new Boar(400, 2, 50d));
            return boars;
        }
        return null;
    }

    @Override
    public void move() {
        for (Boar boar : boars) {
            int x = ThreadLocalRandom.current().nextInt(speed);
            int y = ThreadLocalRandom.current().nextInt(speed);
            boar.setLocation(new Location());
        }

    }

    public List<Boar> getBoars() {
        return boars;
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
