package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.wolf.Wolf;
import com.aleksei.animalisland.services.IslandService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WolfService {
    private IslandService island;
    private List<Wolf> wolves = new ArrayList<>();
    private final List<Wolf> justBorn = new ArrayList<>();
    public List<Wolf> updateCaterpillars() {
        new ArrayList<>(wolves).forEach(this::animalTurn);
        wolves = wolves.stream().filter(Animal::isAlive)
                .collect(Collectors.toList());
        justBorn.forEach(this::addWolf);
        List<Wolf> backup = new ArrayList<>(justBorn);
        justBorn.clear();
        return backup;
    }
    private void addWolf(Wolf wolf) {
        wolf.addBirthListener(justBorn::add);
        wolves.add(wolf);
    }
    public Stream<Wolf> wolfStream(){
        return wolves.stream();
    }

    public void animalTurn(Animal<?> animal) {
        animal.update(island::visibilityFor);
    }
    public int total(){
        return wolves.size();
    }
}
