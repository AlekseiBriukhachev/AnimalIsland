package com.aleksei.animalisland.models.animal.herbivore;


import com.aleksei.animalisland.models.animal.Animal;
import com.aleksei.animalisland.models.animal.Herbivore;
import com.aleksei.animalisland.models.animal.Predator;

public class Boar extends Animal implements Herbivore, Predator {
    public Boar() {
        super("Boar", "\uD83D\uDC17", 400
                , 2, 50);
    }
}
