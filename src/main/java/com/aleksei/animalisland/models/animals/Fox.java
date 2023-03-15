package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.Predator;

public class Fox extends Animal implements Predator {

    public Fox() {
        super("Fox", "\uD83E\uDD8A", 8
                , 2, 2);
    }
}
