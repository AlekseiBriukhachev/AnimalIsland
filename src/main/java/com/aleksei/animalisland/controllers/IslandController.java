package com.aleksei.animalisland.controllers;



import com.aleksei.animalisland.utils.factories.IslandFactory;
import com.aleksei.animalisland.models.Island.Island;
import com.aleksei.animalisland.services.MoveService;
import com.aleksei.animalisland.view.View;

import java.util.Collection;


public class IslandController {
    private final View view = new View();
    private final MoveService moveService = new MoveService();
    private final IslandFactory islandFactory = new IslandFactory();
    private static Island island;
    private final CellController cellController = new CellController();

    {
        island = islandFactory.getInitialIsland();
    }

    public void printInitialIsland() {
        view.printIsland(island, "Start new Island!");
    }

    public void animalEat() {
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(cellController::animalEat);
        view.printIsland(island, "Animal Eat!");
    }

    public void animalMove() {
        island = moveService.animalMove(island);
        view.printIsland(island, "Animal Move");
    }

    public void grassGrow() {
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(cellController::grassGrow);
        view.printIsland(island, "Grass Grow!");
    }

    public void animalReproduction() {
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(cellController::animalReproduction);
        view.printIsland(island, "Animal Reproduction!");
    }
}
