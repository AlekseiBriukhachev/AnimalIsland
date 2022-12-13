package com.briukhachev.aleksei.animals;

import com.briukhachev.aleksei.Location;
import com.briukhachev.aleksei.service.Params;
import com.briukhachev.aleksei.animalplant.Predator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Snake extends Predator {
    private double weight;
    private int speed;
    private double foodQuantity;
    private Params params = new Params();
    private List<Snake> snakes = new ArrayList<>();

    private Snake(double weight, int speed, double foodQuantity){
        this.weight = weight;
        this.speed = speed;
        this.foodQuantity = foodQuantity;
    }

    @Override
    public List<Snake> createNew() {
        if (snakes.size() < params.getSnakeCount()){
            snakes.add(new Snake(15, 1, 3));
            return snakes;
        }
        return null;
    }

    @Override
    public void move() {
        for (Snake snake : snakes) {
            int x = ThreadLocalRandom.current().nextInt(speed);
            int y = ThreadLocalRandom.current().nextInt(speed);
            snake.setLocation(new Location());
        }

    }

    public List<Snake> getSnakes() {
        return snakes;
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
