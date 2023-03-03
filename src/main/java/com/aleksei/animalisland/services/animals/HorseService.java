package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.horse.Horse;
import com.aleksei.animalisland.services.IslandService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HorseService {
    private IslandService island;
    private List<Horse> horses = new ArrayList<>();
    private List<Horse> justBorn = new ArrayList<>();
    public List<Horse> update() {
        new ArrayList<>(horses).forEach(this::animalTurn);
        horses = horses.stream().filter(Animal::isAlive)
                .collect(Collectors.toList());
        justBorn.forEach(this::addHorse);
        List<Horse> backup = new ArrayList<>(justBorn);
        justBorn.clear();
        return backup;
    }
    private void addHorse(Horse horse) {
        horse.addBirthListener(justBorn::add);
        horses.add(horse);
    }
    public Stream<Horse> horseStream(){
        return horses.stream();
    }

    public void animalTurn(Animal<?> animal) {
        animal.update(island::visibilityFor);
    }
    public int total(){
        return horses.size();
    }
}
