package com.aleksei.animalisland.repository.inmemory;

import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.Bear;
import com.aleksei.animalisland.repository.BearRepository;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryBearRepository implements BearRepository {
    private Map<Integer, Animal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        create(new Bear());
        create(new Bear());
        create(new Bear());
        create(new Bear());
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
//        Map<Class<? extends EntityAI>, Integer> victimMap =
//                entityConfig.eatingProbabilityMap.get(hunter.getClass());
//        for (Map.Entry<Class<? extends EntityAI>, Integer> victimEntry : victimMap.entrySet()) {
//            int randomProbability = ThreadLocalRandom.current().nextInt(100);
//
//            if (victimEntry.getValue() != 0 && victimEntry.getValue() >= randomProbability){
//
//                try {
//                    EntityAI entityAI = victimEntry.getKey().getConstructor().newInstance();
//                    log.info(hunter.getName() + " eat " + entityAI.getName() + " with probability " + randomProbability + ". " + hunter.getName() + " power is " + victimEntry.getValue());
//
//                    removeEntity(entityAI);
//
//                } catch (InstantiationException e) {
//                    log.error("TEST - InstantiationException");
//                    throw new RuntimeException(e);
//                } catch (IllegalAccessException e) {
//                    log.error("TEST - IllegalAccessException");
//                    throw new RuntimeException(e);
//                } catch (InvocationTargetException e) {
//                    log.error("TEST - InvocationTargetException");
//                    throw new RuntimeException(e);
//                } catch (NoSuchMethodException e) {
//                    log.error("TEST - NoSuchMethodException");
//                    throw new RuntimeException(e);
//                }
//
//            }
//        }
    }
    public List<Bear> getAll(){
        List<Bear> bears = new ArrayList<>();
        for (var bear: repository.entrySet()){
            bears.add((Bear) bear.getValue());
        }
        return bears;
    }
}
