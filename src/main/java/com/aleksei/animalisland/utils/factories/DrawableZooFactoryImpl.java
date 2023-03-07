package com.aleksei.animalisland.utils.factories;


import com.aleksei.animalisland.models.animals.Bear;
import com.aleksei.animalisland.models.animals.Boar;
import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.view.BearDrawer;
import com.aleksei.animalisland.view.BoarDrawer;
import com.aleksei.animalisland.view.DrawableBear;
import com.aleksei.animalisland.view.DrawableBoar;

public class DrawableZooFactoryImpl implements DrawableZooFactory {

    private final BoarDrawer boarDrawer = new BoarDrawer();
    private final BearDrawer bearDrawer = new BearDrawer();
    private final ZooFactory zooFactory = new RegularZooFactory();

    public DrawableBoar createBoar(Position position) {
        return new DrawableBoar(zooFactory.createBoar(position), boarDrawer);
    }

    public DrawableBear createBear(Position position) {
        return new DrawableBear(zooFactory.createBear(position), bearDrawer);
    }

    @Override
    public DrawableBoar wrap(Boar boar) {
        return new DrawableBoar(boar, boarDrawer);
    }

    @Override
    public DrawableBear wrap(Bear bear) {
        return new DrawableBear(bear, bearDrawer);
    }
}
