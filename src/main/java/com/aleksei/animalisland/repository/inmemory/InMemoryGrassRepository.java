package com.aleksei.animalisland.repository.inmemory;

import com.aleksei.animalisland.model.Grass;
import com.aleksei.animalisland.model.Location;
import com.aleksei.animalisland.repository.GrassRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryGrassRepository implements GrassRepository<Grass> {
    private final Map<Integer, List<Grass>> grassMap = new ConcurrentHashMap<>();

    @Override
    public void create(Grass grass, int locationId) {
        List<Grass> grassList = grassMap.get(locationId);
        grassList.add(grass);
        grassMap.put(locationId, grassList);
    }

    @Override
    public List<Grass> getAllInLocation(int id) {
        return null;
    }
}
