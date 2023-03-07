package com.aleksei.animalisland.view;


public class DrawableWolf extends DrawableLivingUnit<Wolf, WolfDrawer> {

    public DrawableWolf(Wolf object, WolfDrawer drawer) {
        super(object, drawer);
    }

    public Wolf getWolf() {
        return object;
    }
}
