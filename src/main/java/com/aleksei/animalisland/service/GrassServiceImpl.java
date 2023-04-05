package com.aleksei.animalisland.service;

import com.aleksei.animalisland.model.Grass;
import com.aleksei.animalisland.model.Location;
import com.aleksei.animalisland.repository.GrassRepository;
import com.aleksei.animalisland.repository.inmemory.InMemoryGrassRepository;

public class GrassServiceImpl implements GrassService {
    private final GrassRepository<Grass> repository = new InMemoryGrassRepository();

    @Override
    public Grass create(Grass grass, int locationId) {
        return repository.create(grass, locationId);
    }
}
