package com.aleksei.animalisland.models.animal.herbivore;


import com.aleksei.animalisland.models.animal.Animal;
import com.aleksei.animalisland.models.animal.Herbivore;

public class Caterpillar extends Animal implements Herbivore {
    public Caterpillar() {
        super("Caterpillar", "\uD83D\uDC1B", 0.01F
                , 0, 0);
    }
}
