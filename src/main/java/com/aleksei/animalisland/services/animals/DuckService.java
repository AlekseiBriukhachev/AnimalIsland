package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.duck.Duck;
import com.aleksei.animalisland.services.IslandService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuckService {
    private IslandService island;
    private List<Duck> ducks = new ArrayList<>();
    private final List<Duck> justBorn = new ArrayList<>();
    public List<Duck> update() {
        new ArrayList<>(ducks).forEach(this::animalTurn);
        ducks = ducks.stream().filter(Animal::isAlive)
                .collect(Collectors.toList());
        justBorn.forEach(this::addDuck);
        List<Duck> backup = new ArrayList<>(justBorn);
        justBorn.clear();
        return backup;
    }
    private void addDuck(Duck duck) {
        duck.addBirthListener(justBorn::add);
        ducks.add(duck);
    }
    public Stream<Duck> duckStream(){
        return ducks.stream();
    }

    public void animalTurn(Animal<?> animal) {
        animal.update(island::visibilityFor);
    }
    public int total(){
        return ducks.size();
    }
}
