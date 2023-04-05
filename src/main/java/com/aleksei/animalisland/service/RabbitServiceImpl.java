package com.aleksei.animalisland.service;

import com.aleksei.animalisland.model.Location;
import com.aleksei.animalisland.model.Rabbit;
import com.aleksei.animalisland.repository.RabbitRepository;
import com.aleksei.animalisland.repository.inmemory.InMemoryRabbitRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RabbitServiceImpl implements RabbitService {
    private final RabbitRepository<Rabbit> repository = new InMemoryRabbitRepository();
    @Override
    public void create(Rabbit rabbit, int locationId){
        repository.create(rabbit, locationId);
        log.debug("Rabbit was created in location {}", locationId);
    }
}
