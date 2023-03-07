package com.aleksei.animalisland.view;

import com.aleksei.animalisland.config.AppConfig;
import com.aleksei.animalisland.models.Location;
import com.typesafe.config.Config;

import java.awt.*;

public class CellDrawer implements Drawer<Location> {

    private static final AppConfig CONF = AppConfig.getAppConfig();

    private static final Color BORDER = Color.LIGHT_GRAY;

    private final PlantDrawer plantDrawer = new PlantDrawer();

    @Override
    public void draw(Location location, Graphics2D g2d) {
        plantDrawer.draw(location.getPlant(), g2d);
        g2d.setColor(BORDER);
        g2d.drawRect(0, 0, CONF.getIslandWidth() - 1, CONF.getIslandHeight() - 1);
    }
}
