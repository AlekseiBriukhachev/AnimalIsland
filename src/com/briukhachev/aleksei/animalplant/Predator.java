package com.briukhachev.aleksei.animalplant;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {


    public Predator(double weight, int speed, double foodQuantity, boolean isEatable) {
        super(weight, speed, foodQuantity, isEatable);
    }

    @Override
    public boolean eat(Organism organism) {
        if (organism.isEatable()){
            int probability = ThreadLocalRandom.current().nextInt(this.getProbabilityBeEaten());
//            if (probability > 0 && probability <= 60)
        }
        return true;
    }
}
