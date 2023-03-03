package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.boar.Boar;
import com.aleksei.animalisland.services.IslandService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BoarService {
    private IslandService island;
    private List<Boar> boars = new ArrayList<>();
    private final List<Boar> justBorn = new ArrayList<>();


    public List<Boar> update() {
        new ArrayList<>(boars).forEach(this::animalTurn);
        boars = boars.stream().filter(Animal::isAlive)
                .collect(Collectors.toList());
        justBorn.forEach(this::addBoar);
        List<Boar> backup = new ArrayList<>(justBorn);
        justBorn.clear();
        return backup;
    }
    private void addBoar(Boar boar) {
        boar.addBirthListener(justBorn::add);
        boars.add(boar);
    }
    public Stream<Boar> boarStream(){
        return boars.stream();
    }
    public void animalTurn(Animal<?> animal) {
        animal.update(island::visibilityFor);
    }
    public int total(){
        return boars.size();
    }

}
