package com.aleksei.animalisland.models;

import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.utils.Scent;

public class Location extends AbstractCell {
    private final Plant plant;
    private final Scent scent;

    public Location(Plant plant, Position position) {
        super(position);
        this.plant = plant;
        this.scent = new Scent();
    }
    public Plant getPlant(){
        return plant;
    }
    public void updateScent(){
        scent.restore();
    }
    public Scent getScent(){
        return scent;
    }
    public void update(){
        plant.update();
        scent.update();
    }

    @Override
    public String toString() {
        return "Cell{" +
                "plant=" + plant +
                ", scent=" + scent +
                '}';
    }
}
