package com.aleksei.animalisland.services;


import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.Island.Island;
import com.aleksei.animalisland.models.animals.Animal;

public class MoveService {

    public Island animalMove(Island island) {
        Island newIsland = new Island();
        int x = island.getIsland().size();
        int y = island.getIsland().size();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                newIsland.getIsland().get(i).add(j, new Location());
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (Animal animal : island.getIsland().get(i).get(j).getAnimals()) {
                    int animalMaxStep = animal.getSpeed();
                    if (animalMaxStep == 0) {
                        newIsland.getIsland().get(i).get(j).getAnimals().add(animal);

                    } else if (animalMaxStep == 1) {
                        int randomX;
                        int randomY;
                        if (Math.random() < 0.5) {
                            randomX = 0;
                        } else {
                            randomX = 1;
                        }
                        if (Math.random() < 0.5) {
                            randomY = 0;
                        } else {
                            randomY = 1;
                        }
                        newIsland.getIsland().get(randomX).get(randomY).getAnimals().add(animal);
                    } else {
                        int randomX = (int) (Math.random() * animalMaxStep) % x;
                        int randomY = (int) (Math.random() * animalMaxStep) % y;
                        newIsland.getIsland().get(randomX).get(randomY).getAnimals().add(animal);
                    }

                }
                newIsland.getIsland().get(i).get(j).getPlants()
                        .addAll(island.getIsland().get(i).get(j).getPlants());
            }
        }
        island = newIsland;
        return island;
    }
}
