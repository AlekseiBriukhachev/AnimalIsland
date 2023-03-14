package com.aleksei.animalisland.models.animal.herbivore;


import com.aleksei.animalisland.models.animal.Animal;
import com.aleksei.animalisland.models.animal.Herbivore;
import com.aleksei.animalisland.models.animal.Predator;

public class Mouse extends Animal implements Herbivore, Predator {
    public Mouse() {
        super("Mouse", "\uD83D\uDC01", 0.05F
                , 1, 0.01F);
    }
}
