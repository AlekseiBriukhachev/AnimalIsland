package com.aleksei.animalisland.models.animal.herbivore;


import com.aleksei.animalisland.models.animal.Animal;
import com.aleksei.animalisland.models.animal.Herbivore;

public class Rabbit extends Animal implements Herbivore {
    public Rabbit() {
        super("Rabbit", "\uD83D\uDC30"
                , 2, 2, 0.45F);
    }
}
