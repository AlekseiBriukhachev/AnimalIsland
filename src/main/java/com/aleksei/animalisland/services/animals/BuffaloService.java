package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.buffalo.Buffalo;
import com.aleksei.animalisland.services.IslandService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuffaloService {
    private IslandService island;
    private List<Buffalo> buffaloList = new ArrayList<>();
    private final List<Buffalo> justBorn = new ArrayList<>();
    public List<Buffalo> update() {
        new ArrayList<>(buffaloList).forEach(this::animalTurn);
        buffaloList = buffaloList.stream().filter(Animal::isAlive)
                .collect(Collectors.toList());
        justBorn.forEach(this::addBuffalo);
        List<Buffalo> backup = new ArrayList<>(justBorn);
        justBorn.clear();
        return backup;
    }
    private void addBuffalo(Buffalo buffalo) {
        buffalo.addBirthListener(justBorn::add);
        buffaloList.add(buffalo);
    }
    public Stream<Buffalo> buffaloStream(){
        return buffaloList.stream();
    }
    public void animalTurn(Animal<?> animal) {
        animal.update(island::visibilityFor);
    }
    public int total(){
        return buffaloList.size();
    }
}
