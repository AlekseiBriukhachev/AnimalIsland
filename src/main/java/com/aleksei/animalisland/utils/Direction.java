package com.aleksei.animalisland.utils;

import com.aleksei.animalisland.services.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public enum Direction {
    NO(Position.onPosition(0, 0)),
    NORTH(Position.onPosition(0, -1)),
    EAST(Position.onPosition(1, 0)),
    SOUTH(Position.onPosition(0, 1)),
    WEST(Position.onPosition(-1, 0));
    private final Position delta;

    Direction(Position delta) {
        this.delta = delta;
    }
    private static Direction toRelativePosition(Position position){
        return stream(values())
                .filter(direction -> direction.delta.equals(position))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
    public int deltaX(){
        return delta.getX();
    }
    public int deltaY(){
        return delta.getY();
    }
    public Direction opposite(){
        return toRelativePosition(Position.onPosition(-this.deltaX(), -this.deltaY()));
    }
    public static Stream<Direction> shuffleValues(){
        List<Direction> directions = new ArrayList<>(Arrays.asList(values()));
        Collections.shuffle(directions);
        return directions.stream();
    }
}
