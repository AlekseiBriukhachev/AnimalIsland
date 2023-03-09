package com.aleksei.animalisland.services;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.services.animals.*;
import com.aleksei.animalisland.models.Location;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Data
public class IslandService {
    private final int width;
    private final int height;
    private final List<Location> locations;
    private BearService bearService;
    private BoarService boarService;

    private Location onLocation(Position position) {
        return locations.get(position.x() + width * position.y());
    }
}
