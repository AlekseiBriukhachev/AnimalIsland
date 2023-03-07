package com.aleksei.animalisland.view;


import com.aleksei.animalisland.models.animals.Boar;

public class DrawableBoar extends DrawableAnimal<Boar, BoarDrawer> {
    public DrawableBoar(Boar object, BoarDrawer drawer) {
        super(object, drawer);
    }

    public Boar getBoar() {
        return object;
    }
}
