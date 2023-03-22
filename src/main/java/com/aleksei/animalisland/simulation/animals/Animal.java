package com.aleksei.animalisland.simulation.animals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public abstract class Animal {
    public abstract void eat();
    public abstract void move();
    public abstract void reproduce();

}