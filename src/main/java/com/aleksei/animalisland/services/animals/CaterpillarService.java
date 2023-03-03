package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.caterpillar.Caterpillar;
import com.aleksei.animalisland.services.IslandService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CaterpillarService {
    private IslandService island;
    private List<Caterpillar> caterpillars = new ArrayList<>();
    private final List<Caterpillar> justBorn = new ArrayList<>();
    public List<Caterpillar> update() {
        new ArrayList<>(caterpillars).forEach(this::animalTurn);
        caterpillars = caterpillars.stream().filter(Animal::isAlive)
                .collect(Collectors.toList());
        justBorn.forEach(this::addCaterpillar);
        List<Caterpillar> backup = new ArrayList<>(justBorn);
        justBorn.clear();
        return backup;
    }
    private void addCaterpillar(Caterpillar caterpillar) {
        caterpillar.addBirthListener(justBorn::add);
        caterpillars.add(caterpillar);
    }
    public Stream<Caterpillar> caterpillarStream(){
        return caterpillars.stream();
    }

    public void animalTurn(Animal<?> animal) {
        animal.update(island::visibilityFor);
    }
    public int total(){
        return caterpillars.size();
    }
}
