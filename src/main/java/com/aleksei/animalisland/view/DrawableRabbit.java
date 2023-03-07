package com.aleksei.animalisland.view;


public class DrawableRabbit extends DrawableLivingUnit<Rabbit, RabbitDrawer> {
    public DrawableRabbit(Rabbit object, RabbitDrawer drawer) {
        super(object, drawer);
    }

    public Rabbit getRabbit() {
        return object;
    }
}
