package com.aleksei.animalisland.utils.view;

import java.awt.*;

public interface Drawer<T> {

    void draw(T object, Graphics2D g2d);
}
