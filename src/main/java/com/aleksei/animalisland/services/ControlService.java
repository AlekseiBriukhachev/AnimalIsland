package com.aleksei.animalisland.services;


import com.aleksei.animalisland.controllers.IslandController;
import com.aleksei.animalisland.models.Island.Location;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ControlService implements Runnable {
    private final AnimalService animalService = new AnimalService();
    private final GrassGrowService grassGrowService = new GrassGrowService();
    private final ReproductionService reproductionService = new ReproductionService();
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private final IslandController islandController = new IslandController();


    public void animalEat(Location location) {
        animalService.animalEat(location);
    }

    public void grassGrow(Location location) {
        grassGrowService.grassGrow(location);
    }

    public void animalReproduction(Location location) {
        reproductionService.animalReproduction(location);
    }
    @Override
    public void run() {
//        animalService.init();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.scheduleAtFixedRate(islandController::animalEat, 0, 50, TimeUnit.SECONDS);
//        executor.scheduleAtFixedRate(islandController::grassGrow, 2, 7, TimeUnit.SECONDS);
//        executor.scheduleAtFixedRate(islandController::animalMove, 4, 9, TimeUnit.SECONDS);
//        executor.scheduleAtFixedRate(islandController::animalReproduction, 6, 11, TimeUnit.SECONDS);
    }
}
