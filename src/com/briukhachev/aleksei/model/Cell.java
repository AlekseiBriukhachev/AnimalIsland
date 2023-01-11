package com.briukhachev.aleksei.model;

import java.awt.*;

public class Cell {
    private final int x;
    private final int y;
    private Image image;

    public Cell(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
