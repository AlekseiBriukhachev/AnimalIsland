package com.aleksei.animalisland.models.animals;


public class Duck extends Animal implements Herbivore, Predator {
    public Duck() {
        super("Duck", "\uD83E\uDD86", 1
                , 4, 0.14F);
    }
}
