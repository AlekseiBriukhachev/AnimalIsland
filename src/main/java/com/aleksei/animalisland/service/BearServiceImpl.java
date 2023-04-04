package com.aleksei.animalisland.service;

import com.aleksei.animalisland.model.Bear;
import com.aleksei.animalisland.model.Location;
import com.aleksei.animalisland.repository.BearRepository;
import com.aleksei.animalisland.repository.inmemory.InMemoryBearRepository;

public class BearServiceImpl implements BearService {
    private final BearRepository<Bear> repository = new InMemoryBearRepository();
    @Override
    public Bear create(Location location, Bear bear){
        return repository.create(location, bear);
    }
}
