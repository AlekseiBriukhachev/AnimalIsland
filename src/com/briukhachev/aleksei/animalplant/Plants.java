package com.briukhachev.aleksei.animalplant;

import com.briukhachev.aleksei.Params;

import java.util.ArrayList;
import java.util.List;

public class Plants extends Organism {
    private double weight;
    private int x;
    private int y;
    private Params params = new Params();
    private List<Plants> plants = new ArrayList<>();

    private Plants(double weight) {
        this.weight = weight;
//        this.x = x;
//        this.y = y;
    }

    public List<Plants> getNewPlant() {
        if (plants.size() < params.getPlantCount()) {
            plants.add(new Plants(1));
            return plants;
        }
        return null;
    }

    public double getWeight() {
        return weight;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void lifeCycle(){
        getNewPlant();
    }

}
