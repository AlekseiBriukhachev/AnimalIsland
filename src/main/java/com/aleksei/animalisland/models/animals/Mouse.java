package com.aleksei.animalisland.models.animals;


public class Mouse extends Animal implements Herbivore, Predator {
    public Mouse() {
        super("Mouse", "\uD83D\uDC01", 0.05F
                , 1, 0.01F);
    }
}
