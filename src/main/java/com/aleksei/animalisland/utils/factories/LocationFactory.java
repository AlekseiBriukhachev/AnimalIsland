package com.aleksei.animalisland.utils.factories;


import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.plant.Grass;
import com.aleksei.animalisland.utils.Position;
import com.aleksei.animalisland.utils.view.DrawableLocation;
import com.aleksei.animalisland.utils.view.CellDrawer;
import com.aleksei.animalisland.utils.view.HighlightedCellDrawer;

public class LocationFactory {

    private static final CellDrawer DRAWER = new CellDrawer();

    public DrawableLocation create(Position position, Grass grass) {
        return new DrawableLocation(new Location(position, grass), DRAWER, new HighlightedCellDrawer(DRAWER));
    }
}
