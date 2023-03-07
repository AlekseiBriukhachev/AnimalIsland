package com.aleksei.animalisland.view;


import com.aleksei.animalisland.models.Location;

import java.awt.*;

public class DrawableLocation extends DrawableObject<Location, CellDrawer> {

    private Float value;
    private HighlightedCellDrawer hDrawer;

    public DrawableLocation(Location object, CellDrawer drawer, HighlightedCellDrawer hDrawer) {
        super(object, drawer);
        this.hDrawer = hDrawer;
    }

    public Location getLocation() {
        return object;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    @Override
    public void draw(Graphics2D g2d) {
        if (value != null) {
            hDrawer.draw(this, g2d);
        } else {
            super.draw(g2d);
        }
    }
}
