package com.aleksei.animalisland.models.animal.raptor;


import com.aleksei.animalisland.models.animal.Animal;
import com.aleksei.animalisland.models.animal.Predator;

public class Snake extends Animal implements Predator {
    public Snake() {
        super("Snake", "\uD83D\uDC0D", 15
                , 1, 3);
    }
}
