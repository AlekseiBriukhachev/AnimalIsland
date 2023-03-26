package com.aleksei.animalisland.repository.inmemory;

import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.Bear;
import com.aleksei.animalisland.models.animals.Horse;
import com.aleksei.animalisland.repository.HorseRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class InMemoryHorseRepository implements HorseRepository {
    private Map<Integer, Animal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);
    {
        create(new Horse());
        create(new Horse());
        create(new Horse());
        create(new Horse());
    }
    @Override
    public void move() {

    }

    @Override
    public Animal create(Animal animal) {
        if (animal.isNew()){
            animal.setId(counter.incrementAndGet());
        }
        return repository.put(animal.getId(), animal);

    }

    @Override
    public void eatGrass() {

    }
}
