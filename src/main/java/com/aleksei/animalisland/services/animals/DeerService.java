package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.deer.Deer;
import com.aleksei.animalisland.services.IslandService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeerService {
    private IslandService island;
    private List<Deer> deerList = new ArrayList<>();
    private final List<Deer> justBorn = new ArrayList<>();

    public List<Deer> update() {
        new ArrayList<>(deerList).forEach(this::animalTurn);
        deerList = deerList.stream().filter(Animal::isAlive)
                .collect(Collectors.toList());
        justBorn.forEach(this::addDeer);
        List<Deer> backup = new ArrayList<>(justBorn);
        justBorn.clear();
        return backup;
    }

    private void addDeer(Deer deer) {
        deer.addBirthListener(deee -> justBorn.add(deer));
        deerList.add(deer);
    }

    public Stream<Deer> deerStream() {
        return deerList.stream();
    }

    public void animalTurn(Animal<?> animal) {
        animal.update(island::visibilityFor);
    }

    public int total() {
        return deerList.size();
    }
}
