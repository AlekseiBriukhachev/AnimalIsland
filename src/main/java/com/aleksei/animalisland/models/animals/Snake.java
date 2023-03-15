package com.aleksei.animalisland.models.animals;


import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.Predator;

public class Snake extends Animal implements Predator {
    public Snake() {
        super("Snake", "\uD83D\uDC0D", 15
                , 1, 3);
    }
}
