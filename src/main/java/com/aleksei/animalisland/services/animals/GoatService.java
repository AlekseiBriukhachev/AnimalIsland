package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.goat.Goat;
import com.aleksei.animalisland.services.IslandService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GoatService {
    private IslandService island;
    private List<Goat> goats = new ArrayList<>();
    private List<Goat> justBorn = new ArrayList<>();
    public List<Goat> update() {
        new ArrayList<>(goats).forEach(this::animalTurn);
        goats = goats.stream().filter(Animal::isAlive)
                .collect(Collectors.toList());
        justBorn.forEach(this::addGoat);
        List<Goat> backup = new ArrayList<>(justBorn);
        justBorn.clear();
        return backup;
    }
    private void addGoat(Goat goat) {
        goat.addBirthListener(justBorn::add);
        goats.add(goat);
    }
    public Stream<Goat> goatStream(){
        return goats.stream();
    }

    public void animalTurn(Animal<?> animal) {
        animal.update(island::visibilityFor);
    }
    public int total(){
        return goats.size();
    }
}
