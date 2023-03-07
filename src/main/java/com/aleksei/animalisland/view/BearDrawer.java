package com.aleksei.animalisland.view;

import com.aleksei.animalisland.models.animals.Bear;
import com.typesafe.config.Config;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class BearDrawer implements Drawer<Bear> {


    public static BufferedImage IMG;

    static {
        try {
            URL resource = Bear.class.getClassLoader().getResource("Bear.png");
            IMG = resource == null ? null : ImageIO.read(resource);
        } catch (IOException e) {
            IMG = null;
        }
    }

    @Override
    public void draw(Bear bear, Graphics2D g) {

        int xPadding = (int) (g.getClipBounds().getWidth()) / 2 + 1;
        int yPadding = (int) (g.getClipBounds().getHeight()) / 2 + 1;

        g.drawImage(IMG, xPadding, yPadding,  2, 2, null);

        g.fillRect(1, 1, (int) (g.getClipBounds().getWidth() - 1), 2);

    }

}
