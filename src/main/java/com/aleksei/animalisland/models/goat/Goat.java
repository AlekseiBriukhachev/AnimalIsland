package com.aleksei.animalisland.models.goat;


import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.repositories.Herbivores;

public class Goat extends Animal implements Herbivores {
    @Override
    public String toString() {
        return "Goat{"
                + this.getSpeed() + ", "
                + this.getWeight() + ", "
                + this.getFoodQuantity()
                + "}";
    }
}
