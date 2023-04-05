package com.aleksei.animalisland.repository.inmemory;

import com.aleksei.animalisland.model.Bear;
import com.aleksei.animalisland.model.Location;
import com.aleksei.animalisland.repository.BearRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryBearRepository implements BearRepository<Bear> {
    private final Map<Integer, List<Bear>> bearMap = new ConcurrentHashMap<>();

    @Override
    public void move() {

    }

    @Override
    public void reproduce() {

    }

    @Override
    public void create(Bear bear, int locationId) {
        List<Bear> bears = bearMap.get(locationId);
        bears.add(bear);
        bearMap.put(locationId, bears);
    }

    @Override
    public List<Bear> getAllInLocation(int id) {
        return null;
    }

    @Override
    public void eatOtherAnimal() {

    }

}
