package com.aleksei.animalisland.repository.inmemory;

import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.Boar;
import com.aleksei.animalisland.repository.BoarRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class InMemoryBoarRepository implements BoarRepository {
    private Map<Integer, Animal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);
    {
        create(new Boar());
        create(new Boar());
        create(new Boar());
        create(new Boar());
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

    @Override
    public void eatOtherAnimal() {

    }
}
