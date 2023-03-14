package com.aleksei.animalisland.models.animal.herbivore;


import com.aleksei.animalisland.models.animal.Animal;
import com.aleksei.animalisland.models.animal.Herbivore;

public class Goat extends Animal implements Herbivore {
    public Goat() {
        super("Goat", "\uD83D\uDC10", 60
                , 3, 10);
    }
}
