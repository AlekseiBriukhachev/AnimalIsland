package com.aleksei.animalisland.utils.enums;

import com.aleksei.animalisland.utils.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public enum Direction {
    NO(Position.getPosition(0, 0)),
    NORTH(Position.getPosition(0, -1)),
    EAST(Position.getPosition(1, 0)),
    SOUTH(Position.getPosition(0, 1)),
    WEST(Position.getPosition(-1, 0));

    private final Position delta;

    Direction(Position delta) {
        this.delta = delta;
    }

    private static Direction byRelativePosition(Position pos) {
        return stream(values()).filter(d -> d.delta.equals(pos)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public int deltaX() {
        return delta.getX();
    }

    public int deltaY() {
        return delta.getY();
    }

    public Direction opposite() {
        return byRelativePosition(Position.getPosition(-this.delta.getX(), -this.delta.getY()));
    }

    public static Stream<Direction> shuffledValues() {
        List<Direction> directions = new ArrayList<>(Arrays.asList(values()));
        Collections.shuffle(directions);
        return directions.stream();
    }
}
