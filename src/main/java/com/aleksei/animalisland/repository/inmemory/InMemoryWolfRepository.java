package com.aleksei.animalisland.repository.inmemory;

import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.Wolf;
import com.aleksei.animalisland.repository.WolfRepository;
import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class InMemoryWolfRepository implements WolfRepository {
    private Map<Integer, Animal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        create(new Wolf());
        create(new Wolf());
        create(new Wolf());
        create(new Wolf());
    }

    @Override
    public void move() {

    }

    @Override
    public Animal create(Animal animal) {
        if (animal.isNew()) {
            animal.setId(counter.incrementAndGet());
        }
        return repository.put(animal.getId(), animal);
    }

    @Override
    public void eatOtherAnimal(Animal animal) {

    }
}
