package com.aleksei.animalisland.repository.inmemory;

import com.aleksei.animalisland.model.Location;
import com.aleksei.animalisland.model.Rabbit;
import com.aleksei.animalisland.repository.RabbitRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryRabbitRepository implements RabbitRepository<Rabbit> {
    private final Map<Integer, List<Rabbit>> rabbitMap = new ConcurrentHashMap<>();

    @Override
    public void move() {

    }

    @Override
    public void reproduce() {

    }

    @Override
    public void create(Rabbit rabbit, int locationIdd) {
        List<Rabbit> rabbits = rabbitMap.get(locationIdd);
        rabbits.add(rabbit);
        rabbitMap.put(locationIdd, rabbits);
    }

    @Override
    public List<Rabbit> getAllInLocation(int id){
        return null;
    }

    @Override
    public void eatGrass() {

    }
}
