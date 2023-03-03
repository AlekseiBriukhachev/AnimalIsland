package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.fox.Fox;
import com.aleksei.animalisland.services.IslandService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FoxService {
    private IslandService island;
    private List<Fox> foxes = new ArrayList<>();
    private List<Fox> justBorn = new ArrayList<>();
    public List<Fox> update() {
        new ArrayList<>(foxes).forEach(this::animalTurn);
        foxes = foxes.stream().filter(Animal::isAlive)
                .collect(Collectors.toList());
        justBorn.forEach(this::addFox);
        List<Fox> backup = new ArrayList<>(justBorn);
        justBorn.clear();
        return backup;
    }
    private void addFox(Fox fox) {
        fox.addBirthListener(justBorn::add);
        foxes.add(fox);
    }
    public Stream<Fox> foxStream(){
        return foxes.stream();
    }

    public void animalTurn(Animal<?> animal) {
        animal.update(island::visibilityFor);
    }
    public int total(){
        return foxes.size();
    }
}
