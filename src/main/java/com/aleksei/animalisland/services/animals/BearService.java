package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.bear.Bear;
import com.aleksei.animalisland.services.IslandService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BearService {
    private IslandService island;
    private List<Bear> bears = new ArrayList<>();
    private final List<Bear> justBorn = new ArrayList<>();
    public List<Bear> update() {
        new ArrayList<>(bears).forEach(this::animalTurn);
        bears = bears.stream().filter(Animal::isAlive)
                .collect(Collectors.toList());
        justBorn.forEach(this::addBear);
        List<Bear> backup = new ArrayList<>(justBorn);
        justBorn.clear();
        return backup;
    }

    private void addBear(Bear bear) {
        bear.addBirthListener(justBorn::add);
        bears.add(bear);
    }
    public Stream<Bear> bearStream(){
        return bears.stream();
    }

    public void animalTurn(Animal<?> animal) {
        animal.update(island::visibilityFor);
    }
    public int total(){
        return bears.size();
    }

}
