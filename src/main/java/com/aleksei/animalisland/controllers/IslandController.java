package com.aleksei.animalisland.controllers;



import com.aleksei.animalisland.services.AnimalService;
import com.aleksei.animalisland.services.ControlService;
import com.aleksei.animalisland.services.IslandService;
import com.aleksei.animalisland.utils.factories.IslandFactory;
import com.aleksei.animalisland.models.Island.Island;
import com.aleksei.animalisland.services.MoveService;
import com.aleksei.animalisland.view.View;

import java.util.Collection;


public class IslandController {
    private final View view = new View();
    private final MoveService moveService = new MoveService();
    private static Island island;
    private final AnimalService animalService = new AnimalService();
    private final IslandService islandService = new IslandService();
    private final ControlService controlService = new ControlService();

    public void init() {
        animalService.init();
        islandService.init();
        view.printIsland(island, "Start new Island!");
        new Thread(controlService).start();
    }

    public void animalEat() {
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(controlService::animalEat);
        view.printIsland(island, "Animal Eat!");
    }

    public void animalMove() {
        island = moveService.animalMove(island);
        view.printIsland(island, "Animal Move");
    }

    public void grassGrow() {
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(controlService::grassGrow);
        view.printIsland(island, "Grass Grow!");
    }

    public void animalReproduction() {
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(controlService::animalReproduction);
        view.printIsland(island, "Animal Reproduction!");
    }
}
