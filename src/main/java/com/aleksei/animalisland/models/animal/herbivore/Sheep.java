package com.aleksei.animalisland.models.animal.herbivore;


import com.aleksei.animalisland.models.animal.Animal;
import com.aleksei.animalisland.models.animal.Herbivore;

public class Sheep extends Animal implements Herbivore {
    public Sheep() {
        super("Sheep", "\uD83D\uDC11", 70
                , 3, 15);
    }
}
