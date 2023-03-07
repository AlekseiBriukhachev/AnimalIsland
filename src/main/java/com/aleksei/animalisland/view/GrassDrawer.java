package com.aleksei.animalisland.view;

import com.typesafe.config.Config;

import java.awt.*;

public class GrassDrawer implements Drawer<Grass> {

    private static final Config CONF = Configuration.ROOT.getConfig("grass.draw");

    private static final Color COLOR = parse(CONF.getString("color"));

    @Override
    public void draw(Grass grass, Graphics2D g) {
        g.setColor(modify(COLOR, 1 - grass.amountPart()));
        g.fillRect(0, 0, (int) g.getClipBounds().getWidth(), (int) g.getClipBounds().getHeight());
    }
}
