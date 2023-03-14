package com.aleksei.animalisland.models.animal.herbivore;


import com.aleksei.animalisland.models.animal.Animal;
import com.aleksei.animalisland.models.animal.Herbivore;

public class Deer extends Animal implements Herbivore {
    public Deer() {
        super("Deer", "\uD83E\uDD8C", 300
                , 4, 50);
    }
}
