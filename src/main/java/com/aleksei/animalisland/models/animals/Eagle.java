package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.Predator;

public class Eagle extends Animal implements Predator {
    public Eagle() {
        super("Eagle", "\uD83E\uDD85", 6
                , 3, 1);
    }
}
