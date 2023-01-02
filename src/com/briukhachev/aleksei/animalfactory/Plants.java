package com.briukhachev.aleksei.animalfactory;

public class Plants extends Organism {
    private final int weight;

    public Plants(int weight) {
        super(weight);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

}
