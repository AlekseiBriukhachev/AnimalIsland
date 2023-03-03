package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.eagle.Eagle;
import com.aleksei.animalisland.services.IslandService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EagleService {
    private IslandService island;
    private List<Eagle> eagles = new ArrayList<>();
    private List<Eagle> justBorn = new ArrayList<>();
    public List<Eagle> update() {
        new ArrayList<>(eagles).forEach(this::animalTurn);
        eagles = eagles.stream().filter(Animal::isAlive)
                .collect(Collectors.toList());
        justBorn.forEach(this::addEagle);
        List<Eagle> backup = new ArrayList<>(justBorn);
        justBorn.clear();
        return backup;
    }
    private void addEagle(Eagle eagle) {
        eagle.addBirthListener(justBorn::add);
        eagles.add(eagle);
    }
    public Stream<Eagle> eagleStream(){
        return eagles.stream();
    }

    public void animalTurn(Animal<?> animal) {
        animal.update(island::visibilityFor);
    }
    public int total(){
        return eagles.size();
    }
}
