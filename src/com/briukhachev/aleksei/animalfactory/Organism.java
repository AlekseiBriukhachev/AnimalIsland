package com.briukhachev.aleksei.animalfactory;

import com.briukhachev.aleksei.Location;

import java.awt.*;

public abstract class Organism {
    private Location location;
    private Image image;
    private int count;

    public Organism(Location location) {
        this.location = location;
        
        count++;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
