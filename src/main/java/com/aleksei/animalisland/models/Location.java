package com.aleksei.animalisland.models;

import com.aleksei.animalisland.services.Position;
import lombok.Data;

@Data
public class Location {
    private final Plant plant;
    private final Position position;

    public Location(Plant plant, Position position) {
        this.plant = plant;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "plant=" + plant +
                '}';
    }
}
