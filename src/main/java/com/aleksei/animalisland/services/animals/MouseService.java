package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.mouse.Mouse;
import com.aleksei.animalisland.services.IslandService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MouseService {
    private IslandService island;
    private List<Mouse> mouseList = new ArrayList<>();
    private List<Mouse> justBorn = new ArrayList<>();
    public List<Mouse> update() {
        new ArrayList<>(mouseList).forEach(this::animalTurn);
        mouseList = mouseList.stream().filter(Animal::isAlive)
                .collect(Collectors.toList());
        justBorn.forEach(this::addMouse);
        List<Mouse> backup = new ArrayList<>(justBorn);
        justBorn.clear();
        return backup;
    }
    private void addMouse(Mouse mouse) {
        mouse.addBirthListener(justBorn::add);
        mouseList.add(mouse);
    }
    public Stream<Mouse> mouseStream(){
        return mouseList.stream();
    }

    public void animalTurn(Animal<?> animal) {
        animal.update(island::visibilityFor);
    }
    public int total(){
        return mouseList.size();
    }
}
