package com.aleksei.animalisland.service;

import com.aleksei.animalisland.model.Bear;
import com.aleksei.animalisland.repository.BearRepository;
import com.aleksei.animalisland.repository.inmemory.InMemoryBearRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BearServiceImpl implements BearService {
    private final BearRepository<Bear> repository = new InMemoryBearRepository();
    @Override
    public void create(Bear bear, int locationId){
        repository.create(bear, locationId);
        log.debug("Bear was created in location {}", locationId);
    }
}
