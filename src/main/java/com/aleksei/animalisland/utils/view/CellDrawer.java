package com.aleksei.animalisland.utils.view;

import com.aleksei.animalisland.config.AppConfig;
import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.plant.Grass;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;

@Slf4j
public class CellDrawer implements Drawer<Location> {

    private static final AppConfig CONFIG = AppConfig.getAppConfig();

    public static final int SIZE = CONFIG.getLocationSize();
    private static final Color BORDER = Color.LIGHT_GRAY;

    private final GrassDrawer grassDrawer = new GrassDrawer();

    @Override
    public void draw(Location location, Graphics2D g2d) {
        try {
            grassDrawer.draw((Grass) location.getPlants().getClass().getConstructor().newInstance(), g2d);
        g2d.setColor(BORDER);
        g2d.drawRect(0, 0, SIZE - 1, SIZE - 1);
        } catch (InstantiationException e) {
            log.error("InstantiationException");
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            log.error("IllegalAccessException");
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            log.error("InvocationTargetException");
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            log.error("NoSuchMethodException");
            throw new RuntimeException(e);
        }
    }
}
