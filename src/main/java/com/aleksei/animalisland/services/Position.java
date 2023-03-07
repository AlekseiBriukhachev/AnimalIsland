package com.aleksei.animalisland.services;

import com.aleksei.animalisland.utils.Direction;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Position(int x, int y) {

    public static Position onPosition(int x, int y) {
        return new Position(x, y);
    }


    public Position moveTo(Direction direction, int steps) {
        return new Position(
                x() + direction.deltaX() * steps,
                y() + direction.deltaY() * steps
        );
    }

    public Position inDirectionTo(Position to, List<Direction> availableDirections) {
        return availableDirections.stream()
                .map(direction -> Pair.of(direction, to.getDistance(adjust(direction))))
                .min(Comparator.comparingInt(Pair::getValue))
                .map(Pair::getKey)
                .map(this::adjust)
                .orElse(this);
    }

    public Position awayFrom(Position to, List<Direction> availableDirections) {
        return availableDirections.stream()
                .map(direction -> Pair.of(direction, to.getDistance(adjust(direction))))
                .max(Comparator.comparingInt(Pair::getValue))
                .map(Pair::getKey)
                .map(this::adjust)
                .orElse(this);
    }

//    public Set<Position> lookAround(int radius) {
//        Set<Position> result = new HashSet<>();
////        return IntStream.range(y - radius, y + radius)
////                .mapToObj(IntStream.range(x - radius, x + radius)
////                        .mapToObj(Position::onPosition()))
//        for (int dy = y - radius; dy <= y + radius; dy++) {
//            for (int dx = x - radius; dx < x + radius; dx++) {
//                Position availablePosition = Position.onPosition(dx, dy);
//                if (availablePosition.getDistance(this) <= radius && availablePosition.inPosition(sized)) {
//                    result.add(availablePosition);
//                }
//            }
//        }
//        return result;
//    }
//
//    public boolean inPosition(Sized sized) {
//        return !(x < 0 || x >= sized.getWidth() || y < 0 || y >= sized.getHeight());
//    }


    public boolean adjustIn(int minX, int minY, int maxX, int maxY) {
        return x >= maxX || x < minX || y >= maxY || y < minY;
    }

    public int getDistance(Position anotherPosition) {
        return Math.abs(x - anotherPosition.x) + Math.abs(y - anotherPosition.y);
    }

    public Position adjust(Direction direction) {
        return new Position(x + direction.deltaX(), y + direction.deltaY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position position)) return false;

        if (x != position.x) return false;
        return y == position.y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
