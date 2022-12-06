package com.briukhachev.aleksei.animalplant;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {
    private int eatProbability;
    @Override
    public void eat(List<? extends Organism> organisms) {
        for (Organism  organism: organisms) {
            int probability = ThreadLocalRandom.current().nextInt(eatProbability);
            if (organism.getLocation() == this.getLocation()) {
                if (organism instanceof Herbivores
                        || (organism instanceof Predator && probability > 0 && probability <= eatProbability)){
                    organisms.remove(organism);
                }
            }
        }
    }
}
