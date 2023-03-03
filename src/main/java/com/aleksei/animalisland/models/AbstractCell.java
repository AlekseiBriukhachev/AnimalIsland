package com.aleksei.animalisland.models;

import com.aleksei.animalisland.services.Position;

public class AbstractCell {
    private final Position position;

    public AbstractCell(Position position) {
        this.position = position;
    }
    public int getX(){
        return position.x();
    }
    public int getY(){
        return position.y();
    }
    public Position getPosition(){
        return position;
    }

    @Override
    public String toString() {
        return "AbstractCell{" +
                "position=" + position +
                '}';
    }
}
