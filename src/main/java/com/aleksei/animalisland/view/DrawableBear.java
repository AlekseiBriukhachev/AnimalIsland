package com.aleksei.animalisland.view;


import com.aleksei.animalisland.models.animals.Bear;

public class DrawableBear extends DrawableAnimal<Bear, BearDrawer> {

    public DrawableBear(Bear object, BearDrawer drawer) {
        super(object, drawer);
    }

    public Bear getBear() {
        return object;
    }
}
