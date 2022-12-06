package com.briukhachev.aleksei.animalplant;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Herbivores extends Animal {
    private int eatProbability;
    @Override
    public void eat(List<? extends Organism> organisms) {
        for (Organism  organism: organisms) {
            int probability = ThreadLocalRandom.current().nextInt(eatProbability);
            if (organism.getLocation() == this.getLocation()) {
                if (organism instanceof Plants
                        || (organism instanceof Herbivores && probability > 0 && probability <= eatProbability)){
                    organisms.remove(organism);
                }
            }
        }
    }

    public void setEatProbability(int eatProbability) {
        this.eatProbability = eatProbability;
    }
}
