package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.Predator;

public class Bear extends Animal implements Predator {
    public Bear() {
        super("Bear", "\uD83D\uDC3B", 500
                , 2, 2);
    }
}
