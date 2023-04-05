package com.aleksei.animalisland.service;

import com.aleksei.animalisland.model.Bear;
import com.aleksei.animalisland.model.Location;
import com.aleksei.animalisland.repository.BearRepository;
import com.aleksei.animalisland.repository.inmemory.InMemoryBearRepository;

import java.util.List;

public class BearServiceImpl implements BearService {
    private final BearRepository<Bear> repository = new InMemoryBearRepository();
    @Override
    public Bear create(Bear bear, int locationId){
        return repository.create(bear, locationId);
    }
}
