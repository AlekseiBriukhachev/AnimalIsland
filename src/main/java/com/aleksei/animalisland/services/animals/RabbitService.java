package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.rabbit.Rabbit;
import com.aleksei.animalisland.services.IslandService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RabbitService {
    private IslandService island;
    private List<Rabbit> rabbits = new ArrayList<>();
    private final List<Rabbit> justBorn = new ArrayList<>();
    public List<Rabbit> update() {
        new ArrayList<>(rabbits).forEach(this::animalTurn);
        rabbits = rabbits.stream().filter(Animal::isAlive)
                .collect(Collectors.toList());
        justBorn.forEach(this::addRabbit);
        List<Rabbit> backup = new ArrayList<>(justBorn);
        justBorn.clear();
        return backup;
    }
    private void addRabbit(Rabbit rabbit) {
        rabbit.addBirthListener(justBorn::add);
        rabbits.add(rabbit);
    }
    public Stream<Rabbit> rabbitStream(){
        return rabbits.stream();
    }

    public void animalTurn(Animal<?> animal) {
        animal.update(island::visibilityFor);
    }
    public int total(){
        return rabbits.size();
    }
}
