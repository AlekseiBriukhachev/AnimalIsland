package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.Predator;

public class Wolf extends Animal implements Predator {
    public Wolf() {
        super("Wolf", "\uD83D\uDC3A", 50
                , 3, 8);
    }
}
