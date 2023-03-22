package com.aleksei.animalisland.simulation.animals;

import com.aleksei.animalisland.simulation.Island.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public abstract class Animal {
    public abstract void eat(Location location);
    public abstract void move();
    public abstract void reproduce();

}