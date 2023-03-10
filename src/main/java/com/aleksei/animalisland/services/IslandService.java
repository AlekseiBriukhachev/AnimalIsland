package com.aleksei.animalisland.services;


import com.aleksei.animalisland.controller.IslandController;
import com.aleksei.animalisland.models.Location;
import com.aleksei.animalisland.models.Scent;
import com.aleksei.animalisland.models.animals.Bear;
import com.aleksei.animalisland.utils.ScentStorage;
import com.aleksei.animalisland.utils.Sized;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class IslandService implements ScentStorage, Sized {

    private final int width;
    private final int height;

    private final List<Location> locations;
    private IslandController controller;

    public IslandService(int width, int height,
                         List<Location> locations) {
        this.width = width;
        this.height = height;
        this.locations = locations;
    }

    public List<Bear> updateBears() {
        new ArrayList<>(wolves).forEach(this::unitTurn);
        wolves = wolves.stream()
                .filter(LivingUnit::isAlive)
                .collect(Collectors.toList());
        justBornWolves.forEach(this::addWolf);
        ArrayList<Wolf> backup = new ArrayList<>(justBornWolves);
        justBornWolves.clear();
        return backup;
    }

    public List<Rabbit> updateRabbits() {
        new ArrayList<>(rabbits).forEach(this::unitTurn);
        rabbits = rabbits.stream()
                .filter(LivingUnit::isAlive)
                .collect(Collectors.toList());
        justBornRabbits.forEach(this::addRabbit);
        ArrayList<Rabbit> backup = new ArrayList<>(justBornRabbits);
        justBornRabbits.clear();
        return backup;
    }

    public void updateCells() {
        new ArrayList<>(locations).forEach(this::cellTurn);
    }

    private void cellTurn(Cell cell) {
        cell.update();
    }

    private void unitTurn(LivingUnit<?> unit) {
        unit.update(this::visibilityFor);
    }

    public WorldVisibility visibilityFor(LivingUnit<?> unit) {
        return new WorldVisibility(
                getWidth(),
                getHeight(),
                Stream.concat(rabbits.stream(), wolves.stream())
                        .filter(u -> u != unit)
                        .filter(u -> u.getPosition().distance(unit.getPosition()) <= unit.getSight())
                        .collect(Collectors.toList()),
                unit.getPosition()
                        .around(unit.getSight(), this)
                        .stream()
                        .map(this::cellOn).collect(Collectors.toSet())
        );
    }

    @Override
    public Scent get(Position position) {
        return cellOn(position).getScent();
    }

    @Override
    public void update(Position position) {
        cellOn(position).updateScent();
    }

    public Cell cellOn(Position position) {
        return locations.get(position.getY() * width + position.getX());
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public int rabbitsTotal() {
        return rabbits.size();
    }

    public int wolvesTotal() {
        return wolves.size();
    }

    public void addRabbit(Rabbit rabbit) {
        rabbit.addBirthListener(justBornRabbits::add);
        rabbits.add(rabbit);
    }

    public void addWolf(Wolf wolf) {
        wolf.addBirthListener(justBornWolves::add);
        wolves.add(wolf);
    }

    public Stream<LivingUnit<?>> unitsOn(Position position) {
        return Stream.concat(
                new ArrayList<>(rabbits).stream(),
                new ArrayList<>(wolves).stream()
        ).filter(u -> u.getPosition().equals(position));
    }
}
