package com.aleksei.animalisland.models.animal.raptor;


import com.aleksei.animalisland.models.animal.Animal;
import com.aleksei.animalisland.models.animal.Predator;

public class Bear extends Animal implements Predator {
    public Bear() {
        super("Bear", "\uD83D\uDC3B", 500
                , 2, 2);
    }
}
