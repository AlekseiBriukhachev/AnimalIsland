package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.services.Food;

public class Boar extends Animal implements Herbivore, Predator, Food {
    public Boar(int weight, int speed, int foodQuantity) {
        super("Boar", "\uD83D\uDC17", weight
                , speed, foodQuantity);
    }
}
