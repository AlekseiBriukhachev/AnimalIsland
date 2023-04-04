package com.aleksei.animalisland.service;

import com.aleksei.animalisland.model.Location;
import com.aleksei.animalisland.model.Rabbit;
import com.aleksei.animalisland.repository.RabbitRepository;
import com.aleksei.animalisland.repository.inmemory.InMemoryRabbitRepository;

public class RabbitServiceImpl implements RabbitService {
    private final RabbitRepository<Rabbit> repository = new InMemoryRabbitRepository();
    @Override
    public Rabbit create(Location location, Rabbit rabbit){
        return repository.create(location, rabbit);
    }
}
