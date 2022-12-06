package com.briukhachev.aleksei.animalplant;

import com.briukhachev.aleksei.Location;

public abstract class Organism{
    private int x;
    private int y;


    private Location location = new Location(x, y);

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
}
