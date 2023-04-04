package com.aleksei.animalisland.repository.inmemory;

import com.aleksei.animalisland.model.Bear;
import com.aleksei.animalisland.model.Location;
import com.aleksei.animalisland.repository.BearRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryBearRepository implements BearRepository<Bear> {
    private final Map<Location, Bear> bearMap = new ConcurrentHashMap<>();

    @Override
    public void move() {

    }

    @Override
    public void reproduce() {

    }

    @Override
    public Bear create(Location location, Bear bear) {
        return bearMap.put(location, bear);
    }

    @Override
    public List<Bear> getAllInLocation(Location location) {
        return null;
    }

    @Override
    public void eatOtherAnimal() {

    }

//    @Override
//    public Bear create(Bear bear) {
//        return bearMap.put(new Location(), bear);
//    }

}
