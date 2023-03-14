package com.aleksei.animalisland.models.animal.herbivore;


import com.aleksei.animalisland.models.animal.Animal;
import com.aleksei.animalisland.models.animal.Herbivore;
import com.aleksei.animalisland.models.animal.Predator;

public class Duck extends Animal implements Herbivore, Predator {
    public Duck() {
        super("Duck", "\uD83E\uDD86", 1
                , 4, 0.14F);
    }
}
