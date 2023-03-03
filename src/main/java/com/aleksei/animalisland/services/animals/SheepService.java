package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.sheep.Sheep;
import com.aleksei.animalisland.services.IslandService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SheepService {
    private IslandService island;
    private List<Sheep> sheepList = new ArrayList<>();
    private List<Sheep> justBorn = new ArrayList<>();
    public List<Sheep> update() {
        new ArrayList<>(sheepList).forEach(this::animalTurn);
        sheepList = sheepList.stream().filter(Animal::isAlive)
                .collect(Collectors.toList());
        sheepList.forEach(this::addSheep);
        List<Sheep> backup = new ArrayList<>(justBorn);
        justBorn.clear();
        return backup;
    }
    private void addSheep(Sheep sheep) {
        sheep.addBirthListener(justBorn::add);
        sheepList.add(sheep);
    }
    public Stream<Sheep> sheepStream(){
        return sheepList.stream();
    }

    public void animalTurn(Animal<?> animal) {
        animal.update(island::visibilityFor);
    }
    public int total(){
        return sheepList.size();
    }
}
