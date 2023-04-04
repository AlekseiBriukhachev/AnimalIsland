package com.aleksei.animalisland.repository.inmemory;

import com.aleksei.animalisland.model.Location;
import com.aleksei.animalisland.model.Rabbit;
import com.aleksei.animalisland.repository.RabbitRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryRabbitRepository implements RabbitRepository<Rabbit> {
    private final Map<Location, Rabbit> rabbitMap = new ConcurrentHashMap<>();

    @Override
    public void move() {

    }

    @Override
    public void reproduce() {

    }

    @Override
    public Rabbit create(Location location, Rabbit rabbit) {
        return rabbitMap.put(location, rabbit);
    }

    @Override
    public List<Rabbit> getAllInLocation(Location location) {
        return null;
    }

    @Override
    public void eatGrass() {

    }
}
