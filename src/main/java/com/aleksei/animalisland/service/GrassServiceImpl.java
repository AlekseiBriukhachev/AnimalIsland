package com.aleksei.animalisland.service;

import com.aleksei.animalisland.model.Grass;
import com.aleksei.animalisland.model.Location;
import com.aleksei.animalisland.repository.GrassRepository;
import com.aleksei.animalisland.repository.inmemory.InMemoryGrassRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GrassServiceImpl implements GrassService {
    private final GrassRepository<Grass> repository = new InMemoryGrassRepository();

    @Override
    public void create(Grass grass, int locationId) {
        repository.create(grass, locationId);
        log.debug("Grass created in location {}", locationId);
    }
}
