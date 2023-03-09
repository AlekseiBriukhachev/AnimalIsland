package com.aleksei.animalisland.utils.factories;

import com.aleksei.animalisland.models.Location;
import com.aleksei.animalisland.models.Plant;
import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.view.CellDrawer;
import com.aleksei.animalisland.view.DrawableLocation;
import com.aleksei.animalisland.view.HighlightedCellDrawer;

public class CellFactory {

    private static final CellDrawer DRAWER = new CellDrawer();

    public DrawableLocation create(Position position, Plant plant) {
        return new DrawableLocation(new Location(plant, position), DRAWER, new HighlightedCellDrawer(DRAWER));
    }
}