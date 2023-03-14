package com.aleksei.animalisland.models.animal.herbivore;


import com.aleksei.animalisland.models.animal.Animal;
import com.aleksei.animalisland.models.animal.Herbivore;

public class Horse extends Animal implements Herbivore {
    public Horse() {
        super("Horse", "\uD83D\uDC0E", 400
                , 4, 60);
    }
}