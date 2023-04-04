package com.aleksei.animalisland.repository.inmemory;

import com.aleksei.animalisland.model.Grass;
import com.aleksei.animalisland.model.Location;
import com.aleksei.animalisland.repository.GrassRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryGrassRepository implements GrassRepository<Grass> {
    private final Map<Location, Grass> grassMap = new ConcurrentHashMap<>();

    @Override
    public Grass create(Location location, Grass grass) {
        return grassMap.put(location, grass);
    }

    @Override
    public List<Grass> getAllInLocation(Location location) {
        return null;
    }
}
