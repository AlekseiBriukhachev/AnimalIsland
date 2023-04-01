package com.aleksei.animalisland.repository.inmemory;

import com.aleksei.animalisland.models.plant.Grass;
import com.aleksei.animalisland.models.plant.Plant;
import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class InMemoryGrassRepository {
    private final Map<Integer, Plant> repository = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    {
        create(new Grass());
        create(new Grass());
        create(new Grass());
        create(new Grass());
    }

    public Plant create(Plant plant) {
        if (plant.isNew()) {
            plant.setId(counter.incrementAndGet());
        }
        return repository.put(plant.getId(), plant);

    }
}
