package com.aleksei.animalisland.view;

import com.aleksei.animalisland.models.Plant;
import static com.aleksei.animalisland.utils.ColorUtils.modify;

import java.awt.*;

public class PlantDrawer implements Drawer<Plant> {


    private static final Color COLOR = Color.GREEN;

    @Override
    public void draw(Plant plant, Graphics2D g) {
        g.setColor(modify(COLOR, 1)); //TODO change fraction according numbers of plants per location
        g.fillRect(0, 0, (int) g.getClipBounds().getWidth(), (int) g.getClipBounds().getHeight());
    }
}
