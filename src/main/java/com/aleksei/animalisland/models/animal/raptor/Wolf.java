package com.aleksei.animalisland.models.animal.raptor;


import com.aleksei.animalisland.models.animal.Animal;
import com.aleksei.animalisland.models.animal.Predator;

public class Wolf extends Animal implements Predator {
    public Wolf() {
        super("Wolf", "\uD83D\uDC3A", 50
                , 3, 8);
    }
}
