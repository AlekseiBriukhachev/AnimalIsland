package com.aleksei.animalisland.utils;

import com.aleksei.animalisland.models.Location;
import com.aleksei.animalisland.repositories.Visibility;
import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.utils.info.AnimalInfo;
import lombok.Data;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class IslandVisibility implements Visibility {
    private final int width;
    private final int height;
    private final Collection<? extends AnimalInfo> animals;
    private final Collection<Location> locations;

    public IslandVisibility(int width, int height, Collection<? extends AnimalInfo> animals, Collection<Location> locations) {
        this.width = width;
        this.height = height;
        this.animals = animals;
        this.locations = locations;
    }

    @Override
    public Stream<? extends AnimalInfo> animals() {
        return animals.stream();
    }

    @Override
    public Stream<Location> locations() {
        return locations.stream();
    }

    @Override
    public IslandVisibility local(Position position) {
        return new IslandVisibility(
                getWidth(),
                getHeight(),
                animals().filter(animalInfo -> animalInfo.getPosition().equals(position)).collect(Collectors.toList()),
                locations().filter(location -> location.getPosition().equals(position)).collect(Collectors.toList())
                );
    }
}
