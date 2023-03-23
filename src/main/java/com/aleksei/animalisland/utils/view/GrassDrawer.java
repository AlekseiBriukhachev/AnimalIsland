package com.aleksei.animalisland.utils.view;

import com.aleksei.animalisland.config.AppConfig;
import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.plant.Grass;

import java.awt.*;

import static com.aleksei.animalisland.utils.view.ColorUtils.modify;
import static com.aleksei.animalisland.utils.view.ColorUtils.parse;

public class GrassDrawer implements Drawer<Grass> {

    private static final AppConfig CONFIG = AppConfig.getAppConfig();

    private static final Color COLOR = parse(CONFIG.getGrasColor());

    @Override
    public void draw(Grass grass, Graphics2D g) {
        Location location = new Location();
        g.setColor(modify(COLOR, 1 - location.getPlants().size()));
        g.fillRect(0, 0, (int) g.getClipBounds().getWidth(), (int) g.getClipBounds().getHeight());
    }
}
