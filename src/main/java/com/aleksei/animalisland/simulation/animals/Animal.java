package com.aleksei.animalisland.simulation.animals;

import com.aleksei.animalisland.simulation.Island.Location;

public interface Animal {
    void eat(Location location);

    void move();

    void reproduce();

}