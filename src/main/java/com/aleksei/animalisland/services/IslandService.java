package com.aleksei.animalisland.services;


import com.aleksei.animalisland.controllers.IslandController;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IslandService implements Runnable {
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private final IslandController islandController = new IslandController();

    @Override
    public void run() {
        islandController.printInitialIsland();
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
